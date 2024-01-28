package com.alko.frontend.binders

import com.google.gson.annotations.SerializedName

data class LoginRequst(
    @SerializedName("login")
    val username: String,
    @SerializedName("password")
    val password: String
)