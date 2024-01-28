package com.alko.frontend.remote

import com.alko.frontend.binders.LoginRequst
import com.alko.frontend.binders.AlcoholResponse
import com.alko.frontend.binders.BrandResponse
import com.alko.frontend.binders.AlcoholRequest
import com.alko.frontend.binders.Message
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiClient {

    @GET("/alcohol")
    fun getAlcohols(): Call<List<AlcoholResponse>>

    @GET("/brand")
    fun getBrands(): Call<List<BrandResponse>>

    @POST("/alcohol")
    fun postAlcohol(@Body alcoholRequest: AlcoholRequest): Call<List<AlcoholResponse>>

    @POST("/login")
    fun postLogin(@Body loginRequst: LoginRequst): Call<Message>

    @POST("/register")
    fun postRegister(@Body loginRequst: LoginRequst): Call<Message>
}