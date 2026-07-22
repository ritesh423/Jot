package com.example.jot.app

sealed class AuthState {
    data object Checking : AuthState()
    data object Authenticated : AuthState()
    data object Unauthenticated : AuthState()
}