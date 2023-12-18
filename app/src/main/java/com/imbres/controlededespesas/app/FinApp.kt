package com.imbres.controlededespesas.app

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.imbres.controlededespesas.ui.theme.start.MainShow

@Composable
fun FinApp(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        MainShow()
    }
}