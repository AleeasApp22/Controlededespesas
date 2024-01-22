package com.imbres.controlededespesas.navigation

sealed class ScreenSplash(val route: String) {
    object Splash : ScreenSplash("splash_screen")
    object Home : ScreenSplash("home_screen")
    object LostPasswordScreen : ScreenSplash("lost_password_screen")
}
