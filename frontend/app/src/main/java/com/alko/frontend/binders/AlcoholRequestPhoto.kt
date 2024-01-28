package com.alko.frontend.binders


import android.graphics.Bitmap
import com.google.gson.annotations.SerializedName

data class AlcoholRequestPhoto(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("brandId")
    val brandId: Int? = null,
    @SerializedName("photo")
    val photo: Bitmap? = null
)