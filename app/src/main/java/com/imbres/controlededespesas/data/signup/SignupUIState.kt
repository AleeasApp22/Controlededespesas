package com.imbres.controlededespesas.data.signup

data class SignupUIState(
    var email  :String = "",
    var password  :String = "",
    var name  :String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false,
    var nameError :Boolean = false,

)


/*
data class RegistrationUIState(
    var firstName :String = "",
    var lastName  :String = "",
    var name :String = "",
    var email  :String = "",
    var password  :String = "",
    var privacyPolicyAccepted :Boolean = false,


    var firstNameError :Boolean = false,
    var lastNameError : Boolean = false,
    var nameError :Boolean = false,
    var emailError :Boolean = false,
    var passwordError : Boolean = false,
    var privacyPolicyError:Boolean = false

)
*/
