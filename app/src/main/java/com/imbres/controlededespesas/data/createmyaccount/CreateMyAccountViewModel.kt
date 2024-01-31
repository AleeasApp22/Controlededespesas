package com.imbres.controlededespesas.data.createmyaccount

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenAppRouter
import com.imbres.controlededespesas.rules.Validator

class CreateMyAccountViewModel : ViewModel() {

    private val TAG = CreateMyAccountViewModel::class.simpleName

    var createMyAccountUIState = mutableStateOf(CreateMyAccountUIState())

    var allValidationsPassed = mutableStateOf(false)

    var createMyAccountInProgress = mutableStateOf(false)

    fun onEvent(event: CreateMyAccountUIEvent) {
        when (event) {
            is CreateMyAccountUIEvent.EmailChanged -> {
                createMyAccountUIState.value = createMyAccountUIState.value.copy(
                    email = event.email
                )
            }

            is CreateMyAccountUIEvent.NameUserChanged -> {
                createMyAccountUIState.value = createMyAccountUIState.value.copy(
                    name = event.name
                )
            }

            is CreateMyAccountUIEvent.CreateMyAccountButtonClicked -> {
                createMyAccount()
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

    private fun createMyAccount() {

        createMyAccountInProgress.value = true
        val email = createMyAccountUIState.value.email
        val name = createMyAccountUIState.value.name

        AppRouter.navigateTo(ScreenAppRouter.HomeScreenAppRouter)
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

