package com.imbres.controlededespesas.data.login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.navigation.PostOfficeAppRouter
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.rules.Validator

class LostPasswordViewModel : ViewModel() {

    private val TAG = LostPasswordViewModel::class.simpleName

    var lostPaswordUIState = mutableStateOf(LostPasswordUIState())

    var allValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)

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
        validateLoginUIDataWithRules()
    }

    private fun validateLoginUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = lostPaswordUIState.value.email
        )

        allValidationsPassed.value = emailResult.status

    }

    private fun lostPassword() {

        loginInProgress.value = true
        val email = lostPaswordUIState.value.email

        PostOfficeAppRouter.navigateTo(Screen.HomeScreen)

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

