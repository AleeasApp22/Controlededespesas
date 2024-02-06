package com.imbres.controlededespesas.data.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.navigation.ScreenAppRouter
import com.imbres.controlededespesas.rules.Validator

class SignupViewModel : ViewModel() {

    private val TAG = SignupViewModel::class.simpleName

    var createMyAccountUIState = mutableStateOf(SignupUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignupUIEvent) {
        when (event) {
            is SignupUIEvent.EmailChanged -> {
                createMyAccountUIState.value = createMyAccountUIState.value.copy(
                    email = event.email
                )
            }

            is SignupUIEvent.NameUserChanged -> {
                createMyAccountUIState.value = createMyAccountUIState.value.copy(
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
            email = createMyAccountUIState.value.email
        )

        val nameResult = Validator.validateName(
            name = createMyAccountUIState.value.name
        )

        createMyAccountUIState.value = createMyAccountUIState.value.copy(
            emailError = emailResult.status,
            nameError = nameResult.status)

        allValidationsPassed.value = emailResult.status

    }

    private fun signUp() {

        signUpInProgress.value = true
        val email = createMyAccountUIState.value.email
        val name = createMyAccountUIState.value.name

        AppRouter.navigateTo(Screen.Home)
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

