package com.example.jot.app.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jot.core.repository.AuthenticationRepository
import kotlinx.coroutines.launch

class AuthenticationViewModel(
    private val repository: AuthenticationRepository
) : ViewModel() {

    fun register(email: String, password: String) {
        viewModelScope.launch {
            repository.register(email, password)
        }
    }
}