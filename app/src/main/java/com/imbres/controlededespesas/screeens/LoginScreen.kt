package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.components.NormalTitleTextComponent
import com.imbres.controlededespesas.data.LoginViewModel
import com.imbres.controlededespesas.ui.theme.TextColor

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    Column(
        modifier = Modifier
            .background(color = colorResource(id = R.color.greenFinLight)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ){
        NormalTitleTextComponent(
            valueText = stringResource(id = R.string.bem_vindo),
            valueSize = 30,
            valueTextColor = TextColor
        )

        NormalTitleTextComponent(
            valueText = stringResource(id = R.string.login_account),
            valueSize = 25,
            valueTextColor = TextColor
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(id = R.color.greenFinLight))
                .drawWithCache {
                    val brush = Brush.linearGradient(
                        listOf(
                            Color.White,
                            Color.White
                        )
                    )
                    onDrawBehind {
                        drawRoundRect(
                            brush,
                            cornerRadius = CornerRadius(25.dp.toPx())
                        )
                    }
                },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ){
            NormalTitleTextComponent(
                valueText = stringResource(id = R.string.login_account),
                valueSize = 25,
                valueTextColor = TextColor
            )
        }
    }
/*    Column(
        modifier = Modifier
            .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        NormalTitleTextComponent(
            valueText = stringResource(id = R.string.bem_vindo),
            valueSize = 30,
            valueTextColor = TextColor
        )
        NormalTitleTextComponent(
            valueText = stringResource(id = R.string.login_account),
            valueSize = 25,
            valueTextColor = TextColor
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red)
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp
                    )
                ),
        ) {
            NormalTitleTextComponent(
                valueText = stringResource(id = R.string.controle_despesas),
                valueSize = 25,
                valueTextColor = TextColor
            )
        }
    }*/

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}