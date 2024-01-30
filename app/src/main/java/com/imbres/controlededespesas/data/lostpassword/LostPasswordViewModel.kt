package com.imbres.controlededespesas.data.lostpassword

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenAppRouter
import com.imbres.controlededespesas.rules.Validator

class LostPasswordViewModel : ViewModel() {

    private val TAG = LostPasswordViewModel::class.simpleName

    var lostPaswordUIState = mutableStateOf(LostPasswordUIState())

    var allValidationsPassed = mutableStateOf(false)

    var lostPasswordInProgress = mutableStateOf(false)

    fun onEvent(event: LostPasswordUIEvent) {
        when (event) {
            is LostPasswordUIEvent.EmailChanged -> {
                lostPaswordUIState.value = lostPaswordUIState.value.copy(
                    email = event.email
                )
            }

            is LostPasswordUIEvent.LostPasswordButtonClicked -> {
                lostPassword()
            }
        }
        validateLostUIDataWithRules()
    }

    //private fun validateLoginUIDataWithRules() {
    private fun validateLostUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = lostPaswordUIState.value.email
        )

        lostPaswordUIState.value = lostPaswordUIState.value.copy(
            emailError = emailResult.status)

        allValidationsPassed.value = emailResult.status

    }

    private fun lostPassword() {

        lostPasswordInProgress.value = true
        val email = lostPaswordUIState.value.email

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

