package com.example.jot.feature.authentication.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jot.app.ResultState
import com.example.jot.app.navigation.Screen
import com.example.jot.app.viewmodel.AuthenticationViewModel
import com.example.jot.ui.theme.ScreenBackground
import com.example.jot.ui.theme.SplashBackground
import com.example.jot.ui.theme.lorafamily
import com.example.jot.ui.theme.smallHeadings

@Composable
fun RegisterScreen(
    viewModel: AuthenticationViewModel,
    onNavigateToHome: () -> Unit,
    onNavigateToLogin: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(uiState) {
        if (uiState is ResultState.Success) {
            onNavigateToHome()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ScreenBackground)
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {

        Spacer(modifier = Modifier.height(100.dp))

        Text(
            text = "Jot.",
            color = SplashBackground,
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = lorafamily
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Create Account",
            color = Color.Black,
            style = TextStyle(
                fontSize = 34.sp,
                fontFamily = lorafamily
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Free forever. Your notes stay yours.",
            color = smallHeadings
        )

        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            label = {
                Text("Email")
            },
            placeholder = {
                Text("your@email.com")
            },
            textStyle = TextStyle(fontFamily = lorafamily)
        )

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            label = {
                Text("Password")
            },
            placeholder = {
                Text("Password")
            },
            textStyle = TextStyle(fontFamily = lorafamily)
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                viewModel.register(
                    email = email,
                    password = password
                )
            },
            enabled = uiState !is ResultState.Loading,
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 50.dp, width = 0.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = SplashBackground,
                contentColor = Color.White
            )
        ) {

            if (uiState is ResultState.Loading) {

                CircularProgressIndicator(
                    modifier = Modifier.size(22.dp),
                    strokeWidth = 2.dp,
                    color = Color.White
                )

            } else {

                Text("Create Account")

            }

        }

        Spacer(modifier = Modifier.height(20.dp))

        if (uiState is ResultState.Error) {

            Text(
                text = (uiState as ResultState.Error).message,
                color = Color.Red
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text("Already have an account?")

            Text(
                text = "Log in",
                color = SplashBackground,
                modifier = Modifier.clickable {
                    onNavigateToLogin()
                }
            )

        }
    }
}