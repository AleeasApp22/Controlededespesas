package com.imbres.controlededespesas.data.home

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.firestore.FirebaseFirestore
import com.imbres.controlededespesas.data.model.Users
import com.imbres.controlededespesas.data.model.UsersParam
import com.imbres.controlededespesas.navigation.AppRouter
import com.imbres.controlededespesas.navigation.ScreenApp
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class HomeViewModel : ViewModel() {
    val state = mutableStateOf(Users())
    val stateUsersParam = mutableStateOf(UsersParam())
    val userId: MutableLiveData<String> = MutableLiveData()
    var email: String = ""

    private val TAG = HomeViewModel::class.simpleName

    init{
        getData(stateUsersParam)
    }

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


    //fun getUserData() : Any {
    fun getUserData() :  Pair<String, String> {
        FirebaseAuth.getInstance().currentUser?.also {
            it.email?.also { email ->
                //this.email = email
                userId.value = FirebaseAuth.getInstance().uid
                this.stateUsersParam.value.email = email
                this.stateUsersParam.value.userId = FirebaseAuth.getInstance().uid.toString()
                return Pair(stateUsersParam.value.userId, stateUsersParam.value.email)
            }
        }
        return Pair("", "")
    }

    private fun getData(stateUsersParam: MutableState<UsersParam>) {
        viewModelScope.launch {
            state.value = getDataUsers(stateUsersParam)
        }
    }
    suspend fun getDataUsers(stateUsersParam: MutableState<UsersParam>): Users{
        //email = this.stateUsersParam.value.email
        email = stateUsersParam.value.email
        Log.d(TAG, "stateUsersParam email: $email")
        val db = FirebaseFirestore.getInstance()
        var users = Users()
        try {
            db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .await()
                .map {
                    val result = it.toObject(Users::class.java)
                    users = result
                }
        } catch (e: FirebaseAuthException) {
            Log.d(TAG, "getDataUsers error: $e")
        }

        Log.d(TAG, "getDataUsers users.email: ${users.email}")
        Log.d(TAG, "getDataUsers users.name: ${users.name}")

        return users
    }

}