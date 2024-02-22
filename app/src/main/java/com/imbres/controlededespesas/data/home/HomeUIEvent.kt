package com.imbres.controlededespesas.data.home

sealed class HomeUIEvent{

    data class EmailChanged(val email:String): HomeUIEvent()
    data class PasswordChanged(val password: String) : HomeUIEvent()

    object HomeButtonClicked : HomeUIEvent()
}
