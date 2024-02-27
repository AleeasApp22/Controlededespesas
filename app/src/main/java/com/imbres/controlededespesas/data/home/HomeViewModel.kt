package com.imbres.controlededespesas.data.home

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp
import com.imbres.controlededespesas.rules.ValidationResult

class HomeViewModel : ViewModel() {
    var homeUIState = mutableStateOf(HomeUIState())

    fun onEvent(event: HomeUIEvent) {
        home()
    }

    private fun home() {

    }

    val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData()

    fun logout() {

        val firebaseAuth = FirebaseAuth.getInstance()

        firebaseAuth.signOut()

        val authStateListener = FirebaseAuth.AuthStateListener {
            if (it.currentUser == null) {
                Log.d(TAG, "Inside sign outsuccess")
                AppRouter.navigateTo(ScreenApp.LoginScreen)
            } else {
                Log.d(TAG, "Inside sign out is not complete")
            }
        }

        firebaseAuth.addAuthStateListener(authStateListener)

    }

    fun checkForActiveSession() {
        if (FirebaseAuth.getInstance().currentUser != null) {
            Log.d(TAG, "Valid session")
            isUserLoggedIn.value = true
        } else {
            Log.d(TAG, "User is not logged in")
            isUserLoggedIn.value = false
        }
    }


    val nameUser: MutableLiveData<String> = MutableLiveData()
    val emailId: MutableLiveData<String> = MutableLiveData()
    val userId: MutableLiveData<String> = MutableLiveData()

    fun getUserData() {
        FirebaseAuth.getInstance().currentUser?.also {
            it.email?.also { email ->
                emailId.value = email
                userId.value = FirebaseAuth.getInstance().uid
            }
        }
    }

    val documentData: MutableLiveData<String> = MutableLiveData()
    val name: MutableLiveData<String> = MutableLiveData()
    fun readUserData() {
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("users").document("XBDhUkJVV3egNRMBdKqo6lFVnD63")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val data = document.data!!
                    val nameUser = data["name"] as String?
                    name.value = nameUser.toString()
                } else {
                }
            }
            .addOnFailureListener { exception ->
            }
    }

}