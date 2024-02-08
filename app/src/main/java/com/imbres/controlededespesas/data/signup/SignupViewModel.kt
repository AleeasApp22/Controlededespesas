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

    var signUpFail = mutableStateOf(false)

    fun onEvent(event: SignupUIEvent) {
        when (event) {
            is SignupUIEvent.EmailChanged -> {
                signupUIState.value = signupUIState.value.copy(
                    email = event.email
                )
            }

            is SignupUIEvent.PasswordChanged -> {
                signupUIState.value = signupUIState.value.copy(
                    password = event.password
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

        val passwordResult = Validator.validatePassword(
            password = signupUIState.value.password
        )

        signupUIState.value = signupUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )

        allValidationsPassed.value = emailResult.status

    }

    private fun signUp() {

        signUpInProgress.value = true
//        val email = signupUIState.value.email
//        val password = signupUIState.value.password

        createUserInFirebase(
            email = signupUIState.value.email,
            password = signupUIState.value.password,
        )
    }

    private fun createUserInFirebase(email: String, password: String) {

        signUpInProgress.value = true
        signUpFail.value = false

        Log.d(TAG, "email: $email / password: $password")

        if (!email.isEmpty() || !password.isEmpty()) {
            FirebaseAuth
                .getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    Log.d(TAG, "Inside_OnCompleteListener")
                    Log.d(TAG, " isSuccessful = ${it.isSuccessful}")

                    signUpInProgress.value = false
                    if (it.isSuccessful) {
                        AppRouter.navigateTo(ScreenApp.SignUpScreen)
                        //PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                    }
                }
                .addOnFailureListener {
                    signUpFail.value = true

                    Log.d(TAG, "Inside_OnFailureListener")
                    Log.d(TAG, "Exception= ${it.message}")
                    Log.d(TAG, "Exception= ${it.localizedMessage}")
                }
        }
    }
}
