package com.imbres.controlededespesas.data.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var homeUIState = mutableStateOf(HomeUIState())

    fun onEvent(event: HomeUIEvent) {
        home()
    }

    private fun home() {

    }    
}