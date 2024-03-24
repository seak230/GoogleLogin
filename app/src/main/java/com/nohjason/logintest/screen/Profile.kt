package com.nohjason.logintest.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Profile (navController: NavController, value: String?) {
    Column {
        Text(text = "$value")
    }
}