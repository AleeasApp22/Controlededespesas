package com.imbres.controlededespesas.data.newexpense

data class NewExpenseUIState(
    var name: String = "",
    var email: String = "",
    var password1: String = "",
    var password2: String = "",
    var passwordPass: String = "",

    var nameError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError1: Boolean = false,
    var passwordError2: Boolean = false,
    var passwordErrorPass: Boolean = false,

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
