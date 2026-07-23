package com.example.jot.data.remote.dto

data class LoginResponse(
    val success: Boolean,
    val data: Token
)

data class Token(
    val token: String
)