package com.example.jot.data.local.preferences

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(
    name = "user_preferences"
)

class DataStoreManager(
    private val context: Context
) {
    val TOKEN = stringPreferencesKey("token")


    suspend fun saveToken(token: String) {
        context.dataStore.edit { preferences ->
            preferences[TOKEN] = token
        }
    }

    fun getToken(): Flow<String?> {
        return context.dataStore.data.map { preferences ->
            preferences[TOKEN]
        }
    }

    suspend fun clearToken() {
        context.dataStore.edit { preferences ->
            preferences.remove(TOKEN)
        }
    }

}