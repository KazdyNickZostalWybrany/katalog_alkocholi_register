package com.alko.frontend.views.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alko.frontend.R
import com.alko.frontend.adapters.AlcoholRecyclerViewAdapter
import com.alko.frontend.binders.AlcoholRequest
import com.alko.frontend.binders.AlcoholResponse
import com.alko.frontend.remote.ApiClient
import com.alko.frontend.remote.RetrofitClient
import kotlinx.android.synthetic.main.fragment_alcohol_list.imageView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlcoholListFragment : Fragment() {

    private var pictureTaken: Boolean = false
    private var picture: Bitmap = Bitmap.createBitmap(1,1,Bitmap.Config.ARGB_8888)

    private companion object {
        private const val BRAND_NAME_KEY = "brand_name"
        private const val BRAND_ID_KEY = "brand_id"
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_alcohol_list, container, false)
        prepareRecyclerView(root)
        prepareTextInput(root)
        prepareButton(root)
        prepareImageView(root)
        return root
    }


    private fun prepareImageView(root: View) {
        val imageView = root.findViewById<ImageView>(R.id.imageView)
        imageView.setOnClickListener {
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,123)


        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==123){
            var bmp = data?.extras?.get("data") as Bitmap
            this.imageView.setImageBitmap(bmp)
            this.pictureTaken = true;
            this.picture = bmp
            //iv_cam.setImageBitmanp(bmp)
            Toast.makeText(context, "Picture taken", Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepareRecyclerView(root: View) {
        val apiClient = RetrofitClient.client?.create(ApiClient::class.java)
        val call = apiClient?.getAlcohols()
        call?.enqueue(object : Callback<List<AlcoholResponse>>{
            override fun onResponse(call: Call<List<AlcoholResponse>>?, response: Response<List<AlcoholResponse>>?) {
                val brand = arguments?.getString(BRAND_NAME_KEY)
                val recyclerView = root.findViewById<RecyclerView>(R.id.rvAlcohol)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                val adapter = AlcoholRecyclerViewAdapter(requireContext(),response?.body()?.filter { it.brand == brand } ?: ArrayList())
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<AlcoholResponse>>?, t: Throwable?) {
                Toast.makeText(context, "Error occured", Toast.LENGTH_LONG).show()
            }
        })
    }
    private fun prepareTextInput(root: View){



    }

    private fun prepareButton(root: View){
        val addButton = root.findViewById<Button>(R.id.addButton)
        val addTextInput = root.findViewById<EditText>(R.id.editTextAddAlcoholName)
        addButton.setOnClickListener {

            if(addTextInput.text.toString().equals("")){Toast.makeText(context, "You must enter valid name!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            val apiClient = RetrofitClient.client?.create(ApiClient::class.java)
            val brandId = arguments?.getInt(BRAND_ID_KEY)
            if(this.pictureTaken){}
            val call = apiClient?.postAlcohol(AlcoholRequest(addTextInput.text.toString(),brandId));
            call?.enqueue(object : Callback<List<AlcoholResponse>>{
                override fun onResponse(call: Call<List<AlcoholResponse>>?, response: Response<List<AlcoholResponse>>?) {
                    prepareRecyclerView(root);
                    Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<List<AlcoholResponse>>?, t: Throwable?) {
                    Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
                }
            })

        }


    }
}