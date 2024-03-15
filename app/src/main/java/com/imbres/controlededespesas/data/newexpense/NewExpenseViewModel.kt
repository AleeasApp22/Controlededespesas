package com.imbres.controlededespesas.data.newexpense

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.FirebaseError.ERROR_EMAIL_ALREADY_IN_USE
import com.google.firebase.FirebaseError.ERROR_INVALID_CREDENTIAL
import com.google.firebase.FirebaseError.ERROR_INVALID_EMAIL
import com.google.firebase.FirebaseError.ERROR_WRONG_PASSWORD
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.imbres.controlededespesas.data.lostpassword.LostPasswordUIEvent
import com.imbres.controlededespesas.data.lostpassword.LostPasswordUIState
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.Validator

class NewExpenseViewModel : ViewModel() {
    private val TAG = NewExpenseViewModel::class.simpleName

    var newExpenseUIEvent = mutableStateOf(NewExpenseUIState())

    fun onEvent(event: NewExpenseUIEvent) {
        when (event) {
            is NewExpenseUIEvent.NewExpenseButtonClicked -> {
                val index = newExpenseUIEvent.value.index
                Log.d(TAG, "onEvent index: $index")

                //lostPassword()
            }

            is NewExpenseUIEvent.NewExpenseIndex -> TODO()
        }
        //validateLostUIDataWithRules()

    }
}
