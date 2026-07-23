package com.example.jot.data.remote.api

import com.example.jot.data.remote.dto.LoginRequest
import com.example.jot.data.remote.dto.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("api/auth/register")
    suspend fun register(@Body user: LoginRequest) : Response<LoginResponse>

    @POST("api/auth/login")
    suspend fun login(@Body user: LoginRequest) : Response<LoginResponse>
}