package com.imbres.controlededespesas.data.message

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.navigation.ScreenApp

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

        AppRouter.navigateTo(ScreenApp.HomeScreen)

    }
}

