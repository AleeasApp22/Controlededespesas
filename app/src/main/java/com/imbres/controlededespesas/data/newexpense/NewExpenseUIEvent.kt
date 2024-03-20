package com.imbres.controlededespesas.data.newexpense

sealed class NewExpenseUIEvent {
    object NewExpenseButtonClicked : NewExpenseUIEvent()
}
