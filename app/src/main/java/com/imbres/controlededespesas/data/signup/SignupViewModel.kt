package com.imbres.controlededespesas.data.signup

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.Validator

class SignupViewModel : ViewModel() {

    private val TAG = SignupViewModel::class.simpleName

    var signupUIState = mutableStateOf(SignupUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    var signUpPass = mutableStateOf(false)

    var signUpFail = mutableStateOf(false)

    fun onEvent(event: SignupUIEvent) {
        when (event) {
            is SignupUIEvent.EmailChanged -> {
                signupUIState.value = signupUIState.value.copy(
                    email = event.email
                )
            }

            is SignupUIEvent.PasswordChanged1 -> {
                signupUIState.value = signupUIState.value.copy(
                    password1 = event.password1
                )
            }

            is SignupUIEvent.PasswordChanged2 -> {
                signupUIState.value = signupUIState.value.copy(
                    password2 = event.password2
                )
            }

            is SignupUIEvent.SignupButtonClicked -> {
                signUp()
            }
        }
        validateLostUIDataWithRules()
    }

    private fun validateLostUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = signupUIState.value.email
        )

        val passwordResult1 = Validator.validatePasswordPass(
            password1 = signupUIState.value.password1,
            password2 = signupUIState.value.password2
        )

        val passwordResult2 = Validator.validatePasswordPass(
            password1 = signupUIState.value.password1,
            password2 = signupUIState.value.password2
        )

/*
        val passwordResultPass = Validator.validatePasswordsPass(
            password1 = signupUIState.value.password1, password2 = signupUIState.value.password2
        )
*/


        signupUIState.value = signupUIState.value.copy(
            emailError = emailResult.status,
            passwordError1 = passwordResult1.status,
            passwordError2 = passwordResult2.status,
            //passwordErrorPass = passwordResultPass.status
        )

        //Log.d(TAG, "passwordResultPass.status: $passwordResultPass")

        allValidationsPassed.value = emailResult.status

    }

    private fun signUp() {

        signUpInProgress.value = true

        createUserInFirebase(
            email = signupUIState.value.email,
            password = signupUIState.value.password1,
        )
    }

    private fun createUserInFirebase(email: String, password: String) {

        signUpInProgress.value = true
        signUpPass.value = false
        signUpFail.value = false

        if (!email.isEmpty() || !password.isEmpty()) {
            FirebaseAuth
                .getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    signUpInProgress.value = false
                    if (it.isSuccessful) {
                        signUpPass.value = true
                        AppRouter.navigateTo(ScreenApp.SignUpScreen)
                    }
                }
                .addOnFailureListener {
                    signUpFail.value = true
                }
        }
    }
}
