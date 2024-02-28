package com.imbres.controlededespesas.data.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp

class HomeViewModel : ViewModel() {
    var homeUIState = mutableStateOf(HomeUIState())

    private val TAG = HomeViewModel::class.simpleName

    fun onEvent(event: HomeUIEvent) {
        home()
    }

    private fun home() {

    }

    val isUserLoggedIn: MutableLiveData<Boolean> = MutableLiveData()

    @RequiresApi(Build.VERSION_CODES.R)
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


    val emailId: MutableLiveData<String> = MutableLiveData()
    val userId: MutableLiveData<String> = MutableLiveData()
    var email: String = ""

    fun getUserData() :String {
        FirebaseAuth.getInstance().currentUser?.also {
            it.email?.also { email ->
                //emailId.value = email
                this.email = email
                userId.value = FirebaseAuth.getInstance().uid
                return email
            }
        }

        return email
    }


    fun readUserData(email: String): String {

        val db = FirebaseFirestore.getInstance()
        var name: String = ""

        db.collection("users")
            .whereEqualTo("email", email)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    name = document.data["name"].toString()
                }
                Log.d(TAG, "readUserData 1: $name")
            }
            .addOnFailureListener { exception ->
                name = "Error"
                Log.d(TAG, "readUserData 2: $name")
            }

        Log.d(TAG, "readUserData 3: $name")
        return name
    }

}