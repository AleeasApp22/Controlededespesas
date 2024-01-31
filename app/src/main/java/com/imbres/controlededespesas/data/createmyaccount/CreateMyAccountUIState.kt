package com.imbres.controlededespesas.data.createmyaccount

data class CreateMyAccountUIState(
    var email  :String = "",

    var name  :String = "",

    var emailError :Boolean = false,

    var nameError :Boolean = false,

)
