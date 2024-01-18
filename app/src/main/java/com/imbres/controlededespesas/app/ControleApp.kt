package com.imbres.controlededespesas.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.imbres.controlededespesas.screeens.LoginScreen
import com.imbres.controlededespesas.screeens.MessageScreen

@Composable
fun ControleApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        MessageScreen()
        //LoginScreen()
    }
}



