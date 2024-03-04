package com.imbres.controlededespesas.rules
object Validator {

    fun validateFirstName(fName: String): ValidationResult {
        return ValidationResult(
            (!fName.isNullOrEmpty() && fName.length >= 2)
        )

    }

    fun validateLastName(lName: String): ValidationResult {
        return ValidationResult(
            (!lName.isNullOrEmpty() && lName.length >= 2)
        )
    }

    fun validateName(name: String): ValidationResult {
        return ValidationResult(
            (!name.isNullOrEmpty() && name.length >= 6)
        )
    }

    fun validateEmail(email: String): ValidationResult {
        var returnValidate : Boolean
        returnValidate = true

        if (!isValidEmail(email)) {
            returnValidate = false
        }

        return ValidationResult(returnValidate)

    }

    fun validatePassword(password: String): ValidationResult {
        return ValidationResult(
            (password.isNotEmpty() && password.length >= 6)
        )
    }

    fun validatePasswordPass(password1: String, password2: String): ValidationResult {
        return ValidationResult(
            (password1.isNotEmpty() && password1.length >= 6 && password2.isNotEmpty() && password2.length >= 6 && password1 == password2)
        )
    }

    fun validatePrivacyPolicyAcceptance(statusValue:Boolean):ValidationResult{
        return ValidationResult(
            statusValue
        )
    }
}

fun isValidEmail(email: String): Boolean {
    val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
    return email.matches(emailRegex)
}

data class ValidationResult(
    val status: Boolean = false
)