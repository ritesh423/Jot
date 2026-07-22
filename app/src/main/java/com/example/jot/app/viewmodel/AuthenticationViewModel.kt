package com.example.jot.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jot.app.AuthState
import com.example.jot.app.ResultState
import com.example.jot.core.remote.LoginResponse
import com.example.jot.core.repository.AuthenticationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class AuthenticationViewModel(
    private val repository: AuthenticationRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<ResultState<LoginResponse>>(ResultState.Idle)
    val uiState = _uiState.asStateFlow()
    private val _authState = MutableStateFlow<AuthState>(AuthState.Checking)
    val authState = _authState.asStateFlow()

    fun register(email: String, password: String) {
        viewModelScope.launch {
            _uiState.value = ResultState.Loading
            val result = repository.register(email, password)
            _uiState.value = result

        }
    }

    fun checkLoginStatus() {
        viewModelScope.launch {
            val token = repository.getToken().first()
            if (token != null) {

                _authState.value = AuthState.Authenticated

            } else {

                _authState.value = AuthState.Unauthenticated

            }
        }
    }

}
