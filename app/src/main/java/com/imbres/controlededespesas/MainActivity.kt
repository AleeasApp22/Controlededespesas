package com.imbres.controlededespesas

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.imbres.controlededespesas.navigation.SetupNavGraph

private var backPressedTime = 0L


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            SetupNavGraph(navController = navController)

            onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(false){
                override fun handleOnBackPressed() {
                    finish()
                }
            })
        }
    }



/*    override fun onBackPressed(){
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
        } else {
            Toast.makeText(applicationContext,"Pressione voltar novamente para sair do aplicativo",Toast.LENGTH_SHORT).show()
        }
        backPressedTime = System.currentTimeMillis()
        return
    }*/

}

