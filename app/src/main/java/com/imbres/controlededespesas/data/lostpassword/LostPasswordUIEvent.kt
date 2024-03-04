package com.imbres.controlededespesas.data.lostpassword

sealed class LostPasswordUIEvent{
    data class EmailChanged(val email:String): LostPasswordUIEvent()
    object LostPasswordButtonClicked : LostPasswordUIEvent()
}
