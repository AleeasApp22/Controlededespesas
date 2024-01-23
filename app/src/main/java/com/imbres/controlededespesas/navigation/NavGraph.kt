package com.imbres.controlededespesas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imbres.controlededespesas.app.ControleApp
import com.imbres.controlededespesas.SplashScreen
import com.imbres.controlededespesas.screeens.LoginScreen
import com.imbres.controlededespesas.screeens.LostPasswordScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            ControleApp(navController = navController)
        }
        composable(route = Screen.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = Screen.LostPassword.route) {
            LostPasswordScreen(navController = navController)
        }
    }
}