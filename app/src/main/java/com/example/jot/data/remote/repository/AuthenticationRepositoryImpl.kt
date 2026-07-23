package com.example.jot.data.remote.repository

import com.example.jot.core.util.ResultState
import com.example.jot.data.local.preferences.DataStoreManager
import com.example.jot.data.remote.api.AuthApi
import com.example.jot.data.remote.dto.LoginRequest
import com.example.jot.data.remote.dto.LoginResponse
import com.example.jot.domain.repository.AuthenticationRepository

class AuthenticationRepositoryImpl(
    private val dataStoreManager: DataStoreManager,
    private val api: AuthApi
) : AuthenticationRepository {

    override suspend fun register(
        email: String,
        password: String
    ): ResultState<LoginResponse> {

        return try {

            val response = api.register(
                LoginRequest(
                    email = email,
                    password = password
                )
            )

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {

                    saveToken(body.data.token)

                    ResultState.Success(body)

                } else {

                    ResultState.Error("Empty response from server")

                }

            } else {

                ResultState.Error("Registration failed")

            }

        } catch (e: Exception) {

            ResultState.Error(
                e.message ?: "Something went wrong"
            )

        }
    }

    override suspend fun saveToken(token: String) = dataStoreManager.saveToken(token)
    override fun getToken() = dataStoreManager.getToken()
    override suspend fun clearToken() = dataStoreManager.clearToken()
}