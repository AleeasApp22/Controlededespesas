package com.imbres.controlededespesas.data.signup

data class SignupUIState(
    var email  :String = "",
    var password  :String = "",
    var name  :String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false,
    var nameError :Boolean = false,

)
