package com.alko.frontend.binders


import com.google.gson.annotations.SerializedName

data class AlcoholResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("brand")
    val brand: String? = null
)