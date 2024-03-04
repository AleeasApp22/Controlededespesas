package com.imbres.controlededespesas.data.home

data class HomeUIState(
    var email: String = "",
    var password: String = "",

    var emailError: Boolean = false,
    var passwordError: Boolean = false

)
