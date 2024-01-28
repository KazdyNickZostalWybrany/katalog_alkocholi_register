package com.alko.frontend.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alko.frontend.R
import com.alko.frontend.binders.BrandResponse
import com.alko.frontend.remote.ApiClient
import com.alko.frontend.remote.RetrofitClient
import kotlinx.android.synthetic.main.fragment_brand.*
import kotlinx.android.synthetic.main.fragment_brand.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BrandFragment : Fragment() {

    val brandList = ArrayList<BrandResponse>()

    private companion object {
        private const val BRAND_NAME_KEY = "brand_name"
        private const val BRAND_ID_KEY = "brand_id"
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_brand, container, false)
        fillSpinner(root)
        prepareClickListeners(root)
        return root
    }

    private fun fillSpinner(root: View) {
        val apiClient = RetrofitClient.client?.create(ApiClient::class.java)
        val call = apiClient?.getBrands()
        call?.enqueue(object : Callback<List<BrandResponse>> {
            override fun onResponse(call: Call<List<BrandResponse>>, response: Response<List<BrandResponse>>) {
                view?.progressBar?.visibility = View.GONE
                if (brandList.isEmpty()) {
                    brandList.addAll(response.body())
                }
                val adapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_spinner_item, brandList.map { it.name }.toList())
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                root.spinner.adapter = adapter
            }

            override fun onFailure(call: Call<List<BrandResponse>>, t: Throwable?) {
                view?.progressBar?.visibility = View.GONE
                Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun prepareClickListeners(root: View) {
        root.txtSubmit.setOnClickListener {
            if (brandList.isNotEmpty()) {
                val bundle = Bundle()
                bundle.putString(BRAND_NAME_KEY, brandList[spinner.selectedItemPosition].name)
                bundle.putInt(BRAND_ID_KEY, brandList[spinner.selectedItemPosition].id)
                findNavController().navigate(R.id.action_brand_to_alko_list, bundle)
            } else {
                Toast.makeText(context, getString(R.string.error_occurred), Toast.LENGTH_SHORT).show()
            }
        }
    }
}