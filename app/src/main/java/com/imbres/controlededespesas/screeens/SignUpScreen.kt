package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SignUpScreen(
    navController: NavHostController,
){
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

    val navController = rememberNavController()
    SignUpScreen(navController = navController)
}