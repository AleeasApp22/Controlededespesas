package com.imbres.controlededespesas.data.newexpense

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.imbres.controlededespesas.rules.Validator

class NewExpenseViewModel : ViewModel() {
    private val TAG = NewExpenseViewModel::class.simpleName
    var newExpenseUIState = mutableStateOf(NewExpenseUIState())
    var allValidationsPassed = mutableStateOf(false)
    var newExpenseInProgress = mutableStateOf(false)
    var newExpenseReturnInProgress = mutableStateOf(false)

    fun onEvent(
        event: NewExpenseUIEvent,
        index: Int,
        category: String
    )  {
        when (event) {
            is NewExpenseUIEvent.DatePurchase -> {
                newExpenseUIState.value = newExpenseUIState.value.copy(
                    date_purchase = event.date_purchase
                )
            }

            is NewExpenseUIEvent.NewExpenseButtonClicked -> {
                newExpense(index, category)
            }

            is NewExpenseUIEvent.NewExpenseReturnButtonClicked ->
                returnHome()
        }

        validateLostUIDataWithRules()
    }

    private fun validateLostUIDataWithRules() {
        val datePurchaseResult = Validator.validateDatePurchase(
            date_purchase = newExpenseUIState.value.date_purchase
        )

        newExpenseUIState.value = newExpenseUIState.value.copy(
            datePurchaseError = datePurchaseResult.status)
        allValidationsPassed.value = datePurchaseResult.status
    }

    private fun returnHome() {
        newExpenseReturnInProgress.value = true
    }

    private fun newExpense(
        index: Int,
        category: String,
    ) {
        Log.d(TAG, "newExpense index: $index")
        Log.d(TAG, "newExpense category: $category")

        newExpenseInProgress.value = true

    }
    fun onEvent(event: NewExpenseUIEvent.NewExpenseButtonClicked) {
        newExpenseInProgress.value = true
    }
    fun onEvent(event: NewExpenseUIEvent.NewExpenseReturnButtonClicked) {
        newExpenseReturnInProgress.value = true
    }

    fun onEvent(datePurchase: NewExpenseUIEvent.DatePurchase) {
        newExpenseReturnInProgress.value = true
    }

}
