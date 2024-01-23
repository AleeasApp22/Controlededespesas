package com.imbres.controlededespesas.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object LostPasswordScreen : Screen("lost_password_screen")
}
