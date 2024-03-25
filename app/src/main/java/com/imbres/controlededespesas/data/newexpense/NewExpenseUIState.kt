package com.imbres.controlededespesas.data.newexpense

data class NewExpenseUIState(
    var date_purchase: String = "",
    var categorySelected: Int = 0,

    var datePurchaseError: Boolean = false
)
