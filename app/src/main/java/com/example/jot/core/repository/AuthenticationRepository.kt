package com.example.jot.core.repository

import android.content.Context
import com.example.jot.core.remote.AuthApi
import com.example.jot.core.remote.LoginRequest
import com.example.jot.feature.authentication.DataStoreManager

class AuthenticationRepository(
    private val dataStoreManager: DataStoreManager,
    private val api: AuthApi
) {

    suspend fun register(email: String, password: String) =
        api.register(user = LoginRequest(email, password))

    suspend fun saveToken(token: String) = dataStoreManager.saveToken(token)
    fun getToken() = dataStoreManager.getToken()
    suspend fun clearToken() = dataStoreManager.clearToken()
}