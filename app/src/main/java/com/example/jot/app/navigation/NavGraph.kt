package com.example.jot.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.jot.app.MainScreen
import com.example.jot.app.viewmodel.AuthenticationViewModel
import com.example.jot.feature.authentication.ui.RegisterScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    authenticationViewModel: AuthenticationViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Screen.Register.route
    ) {

        composable(Screen.Register.route) {

            RegisterScreen(
                viewModel = authenticationViewModel,
                onNavigateToHome = {

                    navController.navigate(Screen.Home.route) {

                        popUpTo(Screen.Register.route) {
                            inclusive = true
                        }

                    }

                }
            )

        }

        composable(Screen.Home.route) {

            MainScreen()

        }

    }

}
