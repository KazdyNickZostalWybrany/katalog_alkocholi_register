package com.alko.frontend.binders


import com.google.gson.annotations.SerializedName

data class AlcoholRequest(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("brandId")
    val brandId: Int? = null
)