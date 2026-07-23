package com.example.jot.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.jot.app.AppModule
import com.example.jot.presentation.navigation.NavGraph
import com.example.jot.presentation.theme.JotTheme
import com.example.jot.presentation.ui.feature.authentication.AuthenticationViewModel
import com.example.jot.presentation.ui.feature.authentication.AuthenticationViewModelFactory

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
                val repository = AppModule.provideAuthenticationRepository(applicationContext)

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