package com.imbres.controlededespesas.data.message

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.navigation.ScreenAppRouter
import com.imbres.controlededespesas.screeens.LoginScreen

class MessageViewModel : ViewModel() {

    var messageInProgress = mutableStateOf(false)

    fun onEvent(event: MessageUIEvent) {

        when (event) {

            is MessageUIEvent.MessageButtonClicked -> {
                message()
            }
        }
    }


    private fun message() {

        messageInProgress.value = true

        AppRouter.navigateTo(ScreenAppRouter.LoginScreenAppRouter)

    }
}

