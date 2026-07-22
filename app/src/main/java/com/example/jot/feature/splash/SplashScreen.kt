package com.example.jot.feature.splash

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jot.app.AuthState
import com.example.jot.app.viewmodel.AuthenticationViewModel
import com.example.jot.ui.theme.SplashBackground
import com.example.jot.ui.theme.lorafamily
import com.example.jot.ui.theme.smallHeadings
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    viewModel: AuthenticationViewModel,
    onNavigateToRegister: () -> Unit,
    onNavigateToHome: () -> Unit
) {
    val authState by viewModel.authState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.checkLoginStatus()
    }

    LaunchedEffect(authState) {
        if (authState != AuthState.Checking) {

            delay(1200)

            when (authState) {

                AuthState.Authenticated ->
                    onNavigateToHome()

                AuthState.Unauthenticated ->
                    onNavigateToRegister()

                AuthState.Checking -> Unit
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SplashBackground)
    ) {

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Jot.",
                color = Color.White,
                style = TextStyle(
                    fontSize = 38.sp,
                    fontFamily = lorafamily
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Notes & to-dos, beautifully simple.",
                color = Color.White
            )
        }

        Text(
            text = "v1.0",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        )
    }
}

