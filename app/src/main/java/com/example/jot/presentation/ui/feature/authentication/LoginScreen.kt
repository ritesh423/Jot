package com.example.jot.presentation.ui.feature.authentication

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jot.presentation.theme.ScreenBackground
import com.example.jot.presentation.theme.SplashBackground
import com.example.jot.presentation.theme.lorafamily
import com.example.jot.presentation.theme.smallHeadings

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ScreenBackground)
            .padding(horizontal = 30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Jot.",
            color = SplashBackground,
            style = TextStyle(fontSize = 28.sp, fontFamily = lorafamily)
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = "Welcome back",
            color = Color.Black,
            style = TextStyle(fontSize = 34.sp, fontFamily = lorafamily)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Login to your notes and to-dos", color = smallHeadings)
        Spacer(modifier = Modifier.height(50.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(20),
            textStyle = TextStyle(fontFamily = lorafamily),
            label = { Text("Email") },
            placeholder = { Text("your email") }
        )
        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(20),
            textStyle = TextStyle(fontFamily = lorafamily),
            label = { Text(text = "Password") },
            placeholder = { Text(text = "your password") }
        )
        Spacer(modifier = Modifier.height(50.dp))

        Button(
            shape = RoundedCornerShape(50),
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .size(height = 50.dp, width = 0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = SplashBackground,
                contentColor = Color.White
            )
        ) {
            Text(text = "Login" , modifier = Modifier.clickable(onClick = {}))
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "New here?")
            Text(text = "Create Account", color = SplashBackground)
        }
    }
}

@Preview()
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}