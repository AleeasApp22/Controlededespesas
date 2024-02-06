package com.imbres.controlededespesas.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class ScreenAppRouter {
    object SignUpScreenAppRouter : ScreenAppRouter()
    object TermsAndConditionsScreenAppRouter : ScreenAppRouter()
    object LoginScreenAppRouter : ScreenAppRouter()
    object HomeScreenAppRouter : ScreenAppRouter()
    object LostPasswordScreenAppRouter : ScreenAppRouter()
    object CreateMyAccountScreenAppRouter : ScreenAppRouter()
}


object AppRouter {

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUp)

    fun navigateTo(destination: Screen){

        currentScreen.value = destination

    }


}