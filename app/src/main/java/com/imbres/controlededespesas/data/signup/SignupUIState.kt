package com.imbres.controlededespesas.data.signup

data class SignupUIState(
    var email  :String = "",

    var name  :String = "",

    var emailError :Boolean = false,

    var nameError :Boolean = false,

)
