package com.imbres.controlededespesas.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Controle : Screen("controle_screen")
    object Home : Screen("home_screen")
    object Login : Screen("login_screen")
    object LostPassword : Screen("lost_password_screen")
    object SignUp : Screen("sign_up_screen")

}

