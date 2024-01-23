package com.imbres.controlededespesas.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class ScreenAppRouter {
    object SignUpScreenAppRouter : ScreenAppRouter()
    object TermsAndConditionsScreenAppRouter : ScreenAppRouter()
    object LoginScreenAppRouter : ScreenAppRouter()
    object HomeScreenAppRouter : ScreenAppRouter()
    object LostPasswordScreenAppRouter : ScreenAppRouter()
}


object AppRouter {

    var currentScreenAppRouter: MutableState<ScreenAppRouter> = mutableStateOf(ScreenAppRouter.SignUpScreenAppRouter)

    fun navigateTo(destination : ScreenAppRouter){

        currentScreenAppRouter.value = destination

    }


}