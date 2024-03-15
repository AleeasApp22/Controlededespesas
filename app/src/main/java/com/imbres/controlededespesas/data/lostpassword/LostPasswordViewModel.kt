package com.imbres.controlededespesas.data.lostpassword

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseError.ERROR_INVALID_CREDENTIAL
import com.google.firebase.FirebaseError.ERROR_INVALID_EMAIL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.Validator

class LostPasswordViewModel : ViewModel() {
    private val TAG = LostPasswordViewModel::class.simpleName
    var lostPaswordUIState = mutableStateOf(LostPasswordUIState())
    var allValidationsPassed = mutableStateOf(false)
    var lostPasswordInProgress = mutableStateOf(false)
    var lostPasswordPass = mutableStateOf(false)
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
        val email = lostPaswordUIState.value.email

        lostPasswordInProgress.value = true
        lostPasswordPass.value = false
        lostPasswordFail.value = false

        if (!email.isEmpty()) {
            FirebaseAuth
                .getInstance()
                .signInWithEmailAndPassword(email, "password")
                .addOnCompleteListener { task ->
                    Log.d(TAG, "lostPassword: 1")
                    Log.d(TAG, "task isSuccessful: ${task.isSuccessful}")
                    Log.d(TAG, "task exception: ${task.exception}")
                    if (task.isSuccessful) {
                        lostPasswordPass.value = true
                    } else {
                        Log.d(TAG, "lostPassword: 2")
                        if (task.exception is FirebaseAuthException) {
                            val exception = task.exception as FirebaseAuthException
                            when (exception.errorCode) {
                                ERROR_INVALID_CREDENTIAL.toString() -> {
                                    lostPasswordFail.value = true
                                }
                                /*                                ERROR_EMAIL_ALREADY_IN_USE.toString() -> {
                                                                    lostPasswordFail.value = true
                                                                }*/
                                ERROR_INVALID_EMAIL.toString() -> {
                                    lostPasswordFail.value = true
                                }

                                /*                                ERROR_WRONG_PASSWORD.toString() -> {
                                                                    lostPasswordFail.value = true
                                                                }*/
                                else -> {
                                    lostPasswordFail.value = true
                                    lostPasswordInProgress.value = false
                                }
                            }
                        }
                    }
                }
                .addOnFailureListener {
                    if (!email.isEmpty() && !lostPasswordFail.value) {
                        FirebaseAuth
                            .getInstance()
                            .sendPasswordResetEmail(email)
                            .addOnCompleteListener {
                                lostPasswordInProgress.value = false
                                if(it.isSuccessful){
                                    lostPasswordPass.value = true
                                    AppRouter.navigateTo(ScreenApp.LoginScreen)
                                }
                            }
                            .addOnFailureListener {
                                lostPasswordFail.value = true
                            }
                    }
                }
        }
    }
}
