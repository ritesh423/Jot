package com.example.jot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.jot.app.navigation.NavGraph
import com.example.jot.app.viewmodel.AuthenticationViewModel
import com.example.jot.app.viewmodel.AuthenticationViewModelFactory
import com.example.jot.core.remote.RetrofitInstance
import com.example.jot.core.repository.AuthenticationRepository
import com.example.jot.feature.authentication.DataStoreManager
import com.example.jot.ui.theme.JotTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            JotTheme {

                // Navigation Controller
                val navController = rememberNavController()

                // Repository
                val repository = AuthenticationRepository(
                    dataStoreManager = DataStoreManager(applicationContext),
                    api = RetrofitInstance.api
                )

                // ViewModel
                val authenticationViewModel: AuthenticationViewModel = viewModel(
                    factory = AuthenticationViewModelFactory(repository)
                )

                // Navigation Graph
                NavGraph(
                    navController = navController,
                    authenticationViewModel = authenticationViewModel
                )

            }

        }

    }

}