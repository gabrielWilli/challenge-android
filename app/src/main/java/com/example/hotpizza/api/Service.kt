package com.example.hotpizza.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    companion object {
        fun getInstance(path: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}