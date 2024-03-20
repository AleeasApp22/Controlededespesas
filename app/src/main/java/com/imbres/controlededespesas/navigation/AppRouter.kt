package com.imbres.controlededespesas.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class ScreenApp {
    object SignUpScreen : ScreenApp()
    object LoginScreen : ScreenApp()
}

object AppRouter {
    var currentScreen: MutableState<ScreenApp> = mutableStateOf(ScreenApp.SignUpScreen)

    fun navigateTo(destination: ScreenApp) {
        currentScreen.value = destination
    }
}