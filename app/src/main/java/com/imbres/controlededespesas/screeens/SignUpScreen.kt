package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.components.NormalTextComponent

@Composable
fun SignUpScreen(){
    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {
        //NormalTextComponent(value = stringResource(id = R.string.greeting))
    }
}

@Preview
@Composable
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}