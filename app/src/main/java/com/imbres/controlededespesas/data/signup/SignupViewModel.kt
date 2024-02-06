package com.imbres.controlededespesas.data.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.Validator

class SignupViewModel : ViewModel() {

    private val TAG = SignupViewModel::class.simpleName

    var signupUIState = mutableStateOf(SignupUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignupUIEvent) {
        when (event) {
            is SignupUIEvent.EmailChanged -> {
                signupUIState.value = signupUIState.value.copy(
                    email = event.email
                )
            }

            is SignupUIEvent.NameUserChanged -> {
                signupUIState.value = signupUIState.value.copy(
                    name = event.name
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

        val nameResult = Validator.validateName(
            name = signupUIState.value.name
        )

        signupUIState.value = signupUIState.value.copy(
            emailError = emailResult.status,
            nameError = nameResult.status)

        allValidationsPassed.value = emailResult.status

    }

    private fun signUp() {

        signUpInProgress.value = true
        val email = signupUIState.value.email
        val name = signupUIState.value.name

        AppRouter.navigateTo(ScreenApp.SignUpScreen)
    }
        /* FirebaseAuth
             .getInstance()
             .signInWithEmailAndPassword(email, password)
             .addOnCompleteListener {
                 Log.d(TAG,"Inside_login_success")
                 Log.d(TAG,"${it.isSuccessful}")

                 if(it.isSuccessful){
                     loginInProgress.value = false
                     PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                 }
             }
             .addOnFailureListener {
                 Log.d(TAG,"Inside_login_failure")
                 Log.d(TAG,"${it.localizedMessage}")

                 loginInProgress.value = false

             }*/

    }

