package com.alko.frontend.binders

import com.google.gson.annotations.SerializedName

data class BrandResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)