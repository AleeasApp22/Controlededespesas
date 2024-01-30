package com.imbres.controlededespesas.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Login : Screen("login_screen")
    object LostPassword : Screen("lost_password_screen")
    object CreateMyAccount : Screen("create_my_account_screen")
}
