package com.imbres.controlededespesas.data.newexpense

sealed class NewExpenseUIEvent {
    data class NewExpenseIndex(val index: Int) : NewExpenseUIEvent()
    object NewExpenseButtonClicked : NewExpenseUIEvent()
}
