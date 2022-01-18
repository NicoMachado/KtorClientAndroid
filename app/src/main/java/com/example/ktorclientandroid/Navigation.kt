package com.example.ktorclientandroid

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ktorclientandroid.compose.PostsKtorDemo

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = "MainMenu"){
        composable("MainMenu"){
            MainMenu(navController = navController, name = "Principal")
        }
        composable("PostsKtorDemo") {
            PostsKtorDemo(navController = navController)
        }

    }
}