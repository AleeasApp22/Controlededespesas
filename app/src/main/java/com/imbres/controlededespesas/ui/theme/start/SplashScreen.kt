package com.imbres.controlededespesas.ui.theme.start

import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.ui.theme.finish.theme.ControleDeDespesasTheme
import com.imbres.controlededespesas.ui.theme.navigation.Screen
import java.nio.file.WatchEvent

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
                navController.navigate(Screen.Home.route)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainSplash(){
    SplashScreen(rememberNavController())
}