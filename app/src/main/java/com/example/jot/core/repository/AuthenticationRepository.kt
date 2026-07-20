package com.example.jot.core.repository

import android.content.Context
import com.example.jot.feature.authentication.DataStoreManager

class AuthenticationRepository(private val dataStoreManager: DataStoreManager) {

    suspend fun saveToken(token: String) = dataStoreManager.saveToken(token)
    fun getToken() = dataStoreManager.getToken()
    suspend fun clearToken() = dataStoreManager.clearToken()
}