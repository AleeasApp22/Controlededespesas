package com.imbres.controlededespesas.data.signup

import com.imbres.controlededespesas.data.login.LoginUIEvent

sealed class SignupUIEvent{

    data class EmailChanged(val email:String): SignupUIEvent()
    data class PasswordChanged(val password: String) : SignupUIEvent()
    object SignupButtonClicked : SignupUIEvent()

}
