package com.imbres.controlededespesas.data.lostpassword

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.Validator

class LostPasswordViewModel : ViewModel() {

    private val TAG = LostPasswordViewModel::class.simpleName

    var lostPaswordUIState = mutableStateOf(LostPasswordUIState())

    var allValidationsPassed = mutableStateOf(false)

    var lostPasswordInProgress = mutableStateOf(false)

    var lostPasswordSucess = mutableStateOf(false)

    var lostPasswordFail = mutableStateOf(false)

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
    private fun validateLostUIDataWithRules() {
        val emailResult = Validator.validateEmail(
            email = lostPaswordUIState.value.email
        )

        lostPaswordUIState.value = lostPaswordUIState.value.copy(
            emailError = emailResult.status)

        allValidationsPassed.value = emailResult.status

    }

    /*
    How To Implement the Reset Password in Firebase using Android Studio and Kotlin
    https://www.youtube.com/watch?v=nVhPqPpgndM
    */

    private fun lostPassword() {

        lostPasswordInProgress.value = true
        lostPasswordSucess.value = false
        lostPasswordFail.value = false

        val email = lostPaswordUIState.value.email

        //AppRouter.navigateTo(ScreenApp.HomeScreen)
        //AppRouter.navigateTo(ScreenAppRouter.SignUpScreenAppRouter)

        if (!email.isEmpty()) {
            FirebaseAuth
                .getInstance()
                .sendPasswordResetEmail(email)
                .addOnCompleteListener {
                    lostPasswordInProgress.value = false
                    if(it.isSuccessful){
                        lostPasswordSucess.value = true
                        //AppRouter.navigateTo(ScreenApp.HomeScreen)
                    }
                }
                .addOnFailureListener {
                    lostPasswordSucess.value = false
                    lostPasswordFail.value = true
                    lostPasswordInProgress.value = false
                }

        }

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

