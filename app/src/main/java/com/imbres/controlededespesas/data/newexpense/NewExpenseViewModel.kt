package com.imbres.controlededespesas.data.newexpense

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.imbres.controlededespesas.data.model.CategoryParam
import com.imbres.controlededespesas.data.model.UsersParam
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.Validator

class NewExpenseViewModel : ViewModel() {

    private val TAG = NewExpenseViewModel::class.simpleName

    var newExpenseUIState = mutableStateOf(NewExpenseUIState())

    var allValidationsPassed = mutableStateOf(false)

    var newExpenseInProgress = mutableStateOf(false)

    var newExpensePass = mutableStateOf(false)

    var newExpenseFail = mutableStateOf(false)

    fun onEvent(
        event: NewExpenseUIEvent,
        usersParam: MutableState<UsersParam>,
        categoryParam: CategoryParam
    ) {
        val usersName = usersParam.value.name
        val categoryId = categoryParam.categoryId
        val categoryName = categoryParam.categoryId

        when (event) {
            is NewExpenseUIEvent.NameChanged -> {
                newExpenseUIState.value = newExpenseUIState.value.copy(
                    name = event.name
                )
            }

            is NewExpenseUIEvent.EmailChanged -> {
                newExpenseUIState.value = newExpenseUIState.value.copy(
                    email = event.email
                )
            }

            is NewExpenseUIEvent.PasswordChanged1 -> {
                newExpenseUIState.value = newExpenseUIState.value.copy(
                    password1 = event.password1
                )
            }

            is NewExpenseUIEvent.PasswordChanged2 -> {
                newExpenseUIState.value = newExpenseUIState.value.copy(
                    password2 = event.password2
                )
            }

            is NewExpenseUIEvent.NewExpenseButtonClicked -> {
                signUp(usersName)
            }
        }
        validateLostUIDataWithRules()
    }

    private fun validateLostUIDataWithRules() {
        val nameResult = Validator.validateName(
            name = newExpenseUIState.value.name
        )

        val emailResult = Validator.validateEmail(
            email = newExpenseUIState.value.email
        )

        val passwordResult1 = Validator.validatePasswordPass(
            password1 = newExpenseUIState.value.password1,
            password2 = newExpenseUIState.value.password2
        )

        val passwordResult2 = Validator.validatePasswordPass(
            password1 = newExpenseUIState.value.password1,
            password2 = newExpenseUIState.value.password2
        )

        newExpenseUIState.value = newExpenseUIState.value.copy(
            nameError = nameResult.status,
            emailError = emailResult.status,
            passwordError1 = passwordResult1.status,
            passwordError2 = passwordResult2.status,
        )

        allValidationsPassed.value = emailResult.status

    }

    private fun signUp(usersName : String) {

        newExpenseInProgress.value = true
        createUserInFirebase(
            name = newExpenseUIState.value.name,
            email = newExpenseUIState.value.email,
            password = newExpenseUIState.value.password1,
        )
    }

    private fun createUserInFirebase(name: String, email: String, password: String) {

        newExpenseInProgress.value = true
        newExpensePass.value = false
        newExpenseFail.value = false

        val userId: MutableLiveData<String> = MutableLiveData()
        val db = FirebaseFirestore.getInstance()

        if (!email.isEmpty() || !password.isEmpty()) {
            FirebaseAuth
                .getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    userId.value = FirebaseAuth.getInstance().uid
                    newExpenseInProgress.value = false
                    if (it.isSuccessful) {
                        newExpensePass.value = true

                        val data = hashMapOf(
                            "name" to name,
                            "email" to email,
                        )

                        db.collection("users").document(userId.value.toString())
                            .set(data)
                            .addOnSuccessListener {
                                Log.d(
                                    TAG,
                                    "DocumentSnapshot successfully written!"
                                )
                            }
                            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

                        AppRouter.navigateTo(ScreenApp.SignUpScreen)
                    }
                }
                .addOnFailureListener {
                    newExpenseFail.value = true
                }
        }
    }
}
