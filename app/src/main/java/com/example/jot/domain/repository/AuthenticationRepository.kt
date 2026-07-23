package com.example.jot.domain.repository

import com.example.jot.core.util.ResultState
import com.example.jot.data.remote.dto.LoginResponse
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {
    suspend fun register(email: String, password: String): ResultState<LoginResponse>
    suspend fun saveToken(token: String)
    fun getToken(): Flow<String?>
    suspend fun clearToken()
}
