package com.example.jot.core.repository

import android.content.Context
import com.example.jot.app.ResultState
import com.example.jot.core.remote.AuthApi
import com.example.jot.core.remote.LoginRequest
import com.example.jot.core.remote.LoginResponse
import com.example.jot.feature.authentication.DataStoreManager

class AuthenticationRepository(
    private val dataStoreManager: DataStoreManager,
    private val api: AuthApi
) {

    suspend fun register(
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

    suspend fun saveToken(token: String) = dataStoreManager.saveToken(token)
    fun getToken() = dataStoreManager.getToken()
    suspend fun clearToken() = dataStoreManager.clearToken()
}