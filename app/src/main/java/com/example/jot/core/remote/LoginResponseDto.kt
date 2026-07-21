package com.example.jot.core.remote

data class LoginResponse(
    val success: Boolean,
    val data: Token
)

data class Token(
    val token: String
)