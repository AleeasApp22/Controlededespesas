package com.imbres.controlededespesas.data.signup

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.Validator

class SignupViewModel : ViewModel() {

    private val TAG = SignupViewModel::class.simpleName

    var signupUIState = mutableStateOf(SignupUIState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    var signUpPass = mutableStateOf(false)

    var signUpFail = mutableStateOf(false)

    fun onEvent(event: SignupUIEvent) {
        when (event) {
            is SignupUIEvent.NameChanged -> {
                signupUIState.value = signupUIState.value.copy(
                    name = event.name
                )
            }

            is SignupUIEvent.EmailChanged -> {
                signupUIState.value = signupUIState.value.copy(
                    email = event.email
                )
            }

            is SignupUIEvent.PasswordChanged1 -> {
                signupUIState.value = signupUIState.value.copy(
                    password1 = event.password1
                )
            }

            is SignupUIEvent.PasswordChanged2 -> {
                signupUIState.value = signupUIState.value.copy(
                    password2 = event.password2
                )
            }

            is SignupUIEvent.SignupButtonClicked -> {
                signUp()
            }
        }
        validateLostUIDataWithRules()
    }

    private fun validateLostUIDataWithRules() {
        val nameResult = Validator.validateName(
            name = signupUIState.value.name
        )

        val emailResult = Validator.validateEmail(
            email = signupUIState.value.email
        )

        val passwordResult1 = Validator.validatePasswordPass(
            password1 = signupUIState.value.password1,
            password2 = signupUIState.value.password2
        )

        val passwordResult2 = Validator.validatePasswordPass(
            password1 = signupUIState.value.password1,
            password2 = signupUIState.value.password2
        )

        signupUIState.value = signupUIState.value.copy(
            nameError = nameResult.status,
            emailError = emailResult.status,
            passwordError1 = passwordResult1.status,
            passwordError2 = passwordResult2.status,
        )

        allValidationsPassed.value = emailResult.status

    }

    private fun signUp() {

        signUpInProgress.value = true

        createUserInFirebase(
            name = signupUIState.value.name,
            email = signupUIState.value.email,
            password = signupUIState.value.password1,
        )
    }

    private fun createUserInFirebase(name: String, email: String, password: String) {

        signUpInProgress.value = true
        signUpPass.value = false
        signUpFail.value = false

        val userId: MutableLiveData<String> = MutableLiveData()
        val db = FirebaseFirestore.getInstance()

        if (!email.isEmpty() || !password.isEmpty()) {
            FirebaseAuth
                .getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    userId.value = FirebaseAuth.getInstance().uid
                    signUpInProgress.value = false
                    if (it.isSuccessful) {
                        signUpPass.value = true

                        val data = hashMapOf(
                            "name" to name,
                            "email" to email,
                        )

                        db.collection("users").document(userId.value.toString())
                            .set(data)
                            .addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
                            .addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

                        AppRouter.navigateTo(ScreenApp.SignUpScreen)
                    }
                }
                .addOnFailureListener {
                    signUpFail.value = true
                }
        }
    }
}
