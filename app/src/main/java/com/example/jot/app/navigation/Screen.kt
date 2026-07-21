package com.example.jot.app.navigation

sealed class Screen(val route: String) {

    data object Register : Screen("register")

    data object Home : Screen("home")

    data object Todo : Screen("todo")

}