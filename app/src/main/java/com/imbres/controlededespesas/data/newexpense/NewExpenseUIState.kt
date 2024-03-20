package com.imbres.controlededespesas.data.newexpense

data class NewExpenseUIState(
    var email: String = "",
    var emailError: Boolean = false,
    var categorySelected: Int = 0
)
