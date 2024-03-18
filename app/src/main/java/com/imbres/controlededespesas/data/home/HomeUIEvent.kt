package com.imbres.controlededespesas.data.home

import com.imbres.controlededespesas.data.message.MessageUIEvent

sealed class HomeUIEvent {

    data class EmailChanged(val email: String) : HomeUIEvent()
    data class PasswordChanged(val password: String) : HomeUIEvent()

    object HomeButtonClicked : HomeUIEvent()
}
