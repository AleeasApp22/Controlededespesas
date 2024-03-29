package com.imbres.controlededespesas.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Controle : Screen("controle_screen")
    object Home : Screen("home_screen")
    object Login : Screen("login_screen")
    object LostPassword : Screen("lost_password_screen")
    object SignUp : Screen("sign_up_screen")
    object NewExpenseScreen : Screen("new_expense_screen")

}

