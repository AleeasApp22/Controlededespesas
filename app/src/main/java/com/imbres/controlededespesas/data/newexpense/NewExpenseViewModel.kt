package com.imbres.controlededespesas.data.newexpense

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class NewExpenseViewModel : ViewModel() {
    private val TAG = NewExpenseViewModel::class.simpleName

    var newExpenseInProgress = mutableStateOf(false)

    fun onEvent(
        event: NewExpenseUIEvent,
        index: Int,
        category: String
    ) {
        when (event) {
            is NewExpenseUIEvent.NewExpenseButtonClicked -> {
                newExpense(index, category)
            }
        }
    }

    private fun newExpense(
        index: Int,
        category: String,
    ) {
        Log.d(TAG, "newExpense index: $index")
        Log.d(TAG, "newExpense category: $category")

        newExpenseInProgress.value = true
    }

}
