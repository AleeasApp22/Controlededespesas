package com.imbres.controlededespesas.data.login

sealed class LostPasswordUIEvent{

    data class EmailChanged(val email:String): LostPasswordUIEvent()
    object LostPasswordButtonClicked : LostPasswordUIEvent()
}
