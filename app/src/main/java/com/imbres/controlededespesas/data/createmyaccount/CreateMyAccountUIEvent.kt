package com.imbres.controlededespesas.data.createmyaccount

import com.imbres.controlededespesas.data.lostpassword.LostPasswordUIEvent

sealed class CreateMyAccountUIEvent{

    data class EmailChanged(val email:String): CreateMyAccountUIEvent()
    object CreateMyAccountButtonClicked : CreateMyAccountUIEvent()

}
