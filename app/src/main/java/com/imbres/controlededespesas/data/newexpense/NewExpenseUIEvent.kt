package com.imbres.controlededespesas.data.newexpense

import com.imbres.controlededespesas.data.lostpassword.LostPasswordUIEvent

sealed class NewExpenseUIEvent {
    data class DatePurchase(val date_purchase: String) : NewExpenseUIEvent()
    object NewExpenseButtonClicked : NewExpenseUIEvent()
    object NewExpenseReturnButtonClicked : NewExpenseUIEvent()
}
