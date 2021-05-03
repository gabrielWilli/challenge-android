package com.example.hotpizza.api

import com.example.hotpizza.model.Pizza
import com.example.hotpizza.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Endpoints {
    @GET("pizza")
    fun getPizzas() : Call<List<Pizza>>

    @POST("signin")
    fun postSignIn(@Body user: User) : Call<User>
}