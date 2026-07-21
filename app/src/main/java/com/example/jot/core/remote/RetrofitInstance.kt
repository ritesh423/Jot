package com.example.jot.core.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://jot-backend-zx3h.onrender.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: AuthApi = retrofit.create(AuthApi::class.java)
}