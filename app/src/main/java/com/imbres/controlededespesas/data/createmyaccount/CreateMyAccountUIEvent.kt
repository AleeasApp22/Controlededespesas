package com.imbres.controlededespesas.data.createmyaccount

sealed class CreateMyAccountUIEvent{

    data class EmailChanged(val email:String): CreateMyAccountUIEvent()
    data class NameUserChanged(val name:String): CreateMyAccountUIEvent()
    object CreateMyAccountButtonClicked : CreateMyAccountUIEvent()

}
