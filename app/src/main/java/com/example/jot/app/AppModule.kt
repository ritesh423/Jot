package com.example.jot.app

import android.content.Context
import com.example.jot.core.network.RetrofitInstance
import com.example.jot.data.local.preferences.DataStoreManager
import com.example.jot.data.remote.repository.AuthenticationRepositoryImpl
import com.example.jot.domain.repository.AuthenticationRepository

object AppModule {
    fun provideAuthenticationRepository(context: Context): AuthenticationRepository {
        return AuthenticationRepositoryImpl(
            dataStoreManager = DataStoreManager(context),
            api = RetrofitInstance.api
        )
    }
}
