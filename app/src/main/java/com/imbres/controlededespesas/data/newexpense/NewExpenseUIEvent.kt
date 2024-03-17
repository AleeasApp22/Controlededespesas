package com.imbres.controlededespesas.data.newexpense

sealed class NewExpenseUIEvent {

    data class NameChanged(val name: String) : NewExpenseUIEvent()
    data class EmailChanged(val email: String) : NewExpenseUIEvent()
    data class PasswordChanged1(val password1: String) : NewExpenseUIEvent()
    data class PasswordChanged2(val password2: String) : NewExpenseUIEvent()
    object NewExpenseButtonClicked : NewExpenseUIEvent()

}
