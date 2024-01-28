package com.alko.frontend.views.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.alko.frontend.R

class MainActivity : AppCompatActivity() {
    companion object {
        const val API_URL : String = "http://192.168.56.1:8080/";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}