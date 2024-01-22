package com.imbres.controlededespesas.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imbres.controlededespesas.app.ControleApp
import com.imbres.controlededespesas.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenSplash.Splash.route
    ) {
        composable(route = ScreenSplash.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = ScreenSplash.Home.route) {
            ControleApp()
        }
        composable(route = ScreenSplash.LostPasswordScreen.route) {
            ControleApp()
        }
    }
}