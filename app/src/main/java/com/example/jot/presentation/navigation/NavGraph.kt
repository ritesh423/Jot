package com.example.jot.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jot.presentation.ui.feature.authentication.AuthenticationViewModel
import com.example.jot.presentation.ui.feature.authentication.LoginScreen
import com.example.jot.presentation.ui.feature.authentication.RegisterScreen
import com.example.jot.presentation.ui.feature.main.MainScreen
import com.example.jot.presentation.ui.feature.splash.SplashScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    authenticationViewModel: AuthenticationViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {

            SplashScreen(
                viewModel = authenticationViewModel,
                onNavigateToRegister = {
                    navController.navigate(Screen.Register.route) {
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                },
                onNavigateToHome = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screen.Register.route) {

            RegisterScreen(
                viewModel = authenticationViewModel,
                onNavigateToHome = {

                    navController.navigate(Screen.Home.route) {

                        popUpTo(Screen.Register.route) {
                            inclusive = true
                        }

                    }

                },
                onNavigateToLogin = {
                    navController.navigate(Screen.Login.route)
                }
            )

        }
        composable(Screen.Login.route) {
            LoginScreen()
        }

        composable(Screen.Home.route) {

            MainScreen()

        }

    }

}
