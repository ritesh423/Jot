package com.example.jot.presentation.ui.feature.authentication

sealed class AuthState {
    data object Checking : AuthState()
    data object Authenticated : AuthState()
    data object Unauthenticated : AuthState()
}