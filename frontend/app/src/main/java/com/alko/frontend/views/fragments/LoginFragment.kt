package com.alko.frontend.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.alko.frontend.R


import com.alko.frontend.remote.ApiClient
import com.alko.frontend.remote.RetrofitClient

import com.alko.frontend.binders.LoginRequst
import com.alko.frontend.binders.Message
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LoginFragment : Fragment() {

    private companion object {

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        onCreateButton(root)
        return root
    }



    private fun onCreateButton(root: View){
        val loginButton = root.findViewById<Button>(R.id.loginButton)
        val registerButton = root.findViewById<Button>(R.id.registerButton)
        val username = root.findViewById<EditText>(R.id.username)
        val password = root.findViewById<TextView>(R.id.password)
        val progressBar = root.findViewById<TextView>(R.id.progressBar)
        loginButton.setOnClickListener {

            if(username.text.toString().equals("")){Toast.makeText(context, "You must enter valid username!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            if(password.text.toString().equals("")){Toast.makeText(context, "You must enter valid password!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            val serverApi = RetrofitClient.client?.create(ApiClient::class.java)
            var loginRequst = LoginRequst(username.text.toString(),password.text.toString())
            progressBar?.visibility = View.VISIBLE
            val call = serverApi?.postLogin(loginRequst);
            call?.enqueue(object : Callback<Message> {
                override fun onResponse(call: Call<Message>, response: Response<Message>) {
                    progressBar?.visibility = View.GONE
//                    println(response.body().msg)
                    if(response.body().txt.equals("badusername")){Toast.makeText(context, "Bad or empty username", Toast.LENGTH_SHORT).show();return;}
                    if(response.body().txt.equals("badpassword")){Toast.makeText(context, "Bad or empty password", Toast.LENGTH_SHORT).show();return;}
                    if(response.body().txt.equals("success")){Toast.makeText(context, "Logged in", Toast.LENGTH_SHORT).show();findNavController().navigate(R.id.action_fragmentLogin_to_fragmentDoctor2);return;}
                    Toast.makeText(context, response.body().txt, Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<Message>, t: Throwable?) {
                    progressBar?.visibility = View.GONE
                    println(t)
                    Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
                }
            })

        }
        registerButton.setOnClickListener {

            if(username.text.toString().equals("")){Toast.makeText(context, "You must enter valid username!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            if(password.text.toString().equals("")){Toast.makeText(context, "You must enter valid password!", Toast.LENGTH_SHORT).show();return@setOnClickListener;}
            val serverApi = RetrofitClient.client?.create(ApiClient::class.java)
            var loginRequst = LoginRequst(username.text.toString(),password.text.toString())
            progressBar?.visibility = View.VISIBLE
            val call = serverApi?.postRegister(loginRequst);
            call?.enqueue(object : Callback<Message> {
                override fun onResponse(call: Call<Message>, response: Response<Message>) {
                    progressBar?.visibility = View.GONE
//                    println(response.body().msg)
                    if(response.body().txt.equals("takenusername")){Toast.makeText(context, "This username is already taken", Toast.LENGTH_SHORT).show();return;}
                    if(response.body().txt.equals("success")){Toast.makeText(context, "Successfully registered, please log in", Toast.LENGTH_SHORT).show();return;}
//                    if(response.body().msg.equals("success")){Toast.makeText(context, "Zalogowano", Toast.LENGTH_SHORT).show();findNavController().navigate(R.id.action_fragmentLogin_to_fragmentDoctor2);return;}
                    Toast.makeText(context, response.body().txt, Toast.LENGTH_SHORT).show()

                }

                override fun onFailure(call: Call<Message>, t: Throwable?) {
                    progressBar?.visibility = View.GONE
                    println(t)
                    Toast.makeText(context, "Error occured", Toast.LENGTH_SHORT).show()
                }
            })

        }


    }
}