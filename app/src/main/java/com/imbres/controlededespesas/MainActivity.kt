package com.imbres.controlededespesas

import android.app.AlertDialog
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.imbres.controlededespesas.navigation.SetupNavGraph

class MainActivity : ComponentActivity() {

    /*
        Pesquisa:

        - How to Change App Icon in Android Studio using Kotlin
        https://www.youtube.com/watch?v=_ZgaeNTCmzw

        - Money Business And Finance SVG Vector 38
        https://www.svgrepo.com/svg/255163/money-business-and-finance
    */

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