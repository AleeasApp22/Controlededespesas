package com.imbres.controlededespesas.data.signup

sealed class SignupUIEvent{

    data class EmailChanged(val email:String): SignupUIEvent()
    data class NameUserChanged(val name:String): SignupUIEvent()
    object SignupButtonClicked : SignupUIEvent()

}
