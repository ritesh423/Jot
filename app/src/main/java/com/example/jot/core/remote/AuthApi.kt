package com.example.jot.core.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("api/auth/register")
    suspend fun register(@Body user: LoginRequest) : LoginResponse

    @POST("api/auth/login")
    suspend fun login(@Body user: LoginRequest) : LoginResponse
}