package com.imbres.controlededespesas

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.google.android.material.snackbar.Snackbar
import com.imbres.controlededespesas.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {

/*    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            onBackPressedMethod()
        }
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            SetupNavGraph(navController = navController)

            //onBackPressedDispatcher.addCallback(this, onBackPressedCallback)

        }
    }


    private fun onBackPressedMethod() {

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Mensagem")
        builder.setMessage("Encerrar aplicação?")
        builder.setPositiveButton("Sim", { dialog, which -> finish() })
        builder.setNegativeButton("Não", { dialog, which -> })
        val dialog = builder.show()

        dialog.setOnDismissListener {}

        //Toast.makeText(applicationContext, "Pressione voltar novamente para sair do aplicativo", Toast.LENGTH_SHORT).show()
        //finish()

/*        val snackbar = Snackbar.make(View(this@MainActivity), "Mensagem do Snackbar", Snackbar.LENGTH_SHORT)
        snackbar.show()*/
    }
}