package com.imbres.controlededespesas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.ui.theme.ControleDeDespesasTheme

@Composable
fun SplashScreen(navController: NavHostController) {
    /*
    Pesquisa:
    https://github.com/mukeshsolanki/animated-splash-screen
    https://proandroiddev.com/animated-splash-screen-in-android-with-compose-4b7dc1baecc5
    https://lottiefiles.com/animations/organizze-logo-kSQtNlo55l
     */

    ControleDeDespesasTheme{
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.greenFinLight))
        ) {
            val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.logo))
            val logoAnimationState =
                animateLottieCompositionAsState(composition = composition)
            LottieAnimation(
                composition = composition,
                progress = { logoAnimationState.progress }
            )
            if (logoAnimationState.isAtEnd && logoAnimationState.isPlaying) {
                navController.navigate(Screen.Controle.route)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainSplash(){
    SplashScreen(rememberNavController())
}