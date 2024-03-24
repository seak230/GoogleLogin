package com.nohjason.logintest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.nohjason.logintest.screen.Login
import com.nohjason.logintest.screen.Profile

@Composable
fun NavControll() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "profile") {
        composable("login") { Login() }
        composable("profile") {
            Profile(navController = navController, value = "")
        }
        // Add more destinations similarly.
    }
}