package com.imbres.controlededespesas.data.signup

import com.imbres.controlededespesas.data.login.LoginUIEvent

sealed class SignupUIEvent {

    data class NameChanged(val name: String) : SignupUIEvent()
    data class EmailChanged(val email: String) : SignupUIEvent()
    data class PasswordChanged1(val password1: String) : SignupUIEvent()
    data class PasswordChanged2(val password2: String) : SignupUIEvent()
    object SignupButtonClicked : SignupUIEvent()

}
