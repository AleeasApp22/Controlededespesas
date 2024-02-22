package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.components.BlackNormalTextComponent
import com.imbres.controlededespesas.components.NormalTitleTextComponent
import com.imbres.controlededespesas.components.Saudacao
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight
import com.nativemobilebits.loginflow.data.home.HomeViewModelOld
import java.util.Calendar

@Composable
fun HomeScreen(homeViewModel: HomeViewModelOld = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val nomeUsuario : String

    homeViewModel.getUserData()
    nomeUsuario = homeViewModel.emailId.value.toString()

    Column (
        modifier = Modifier
            .background(greenFinLight)
    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
                .background(greenFinLight)
        ){
            Column (
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                BlackNormalTextComponent(
                    valueText = Saudacao(),
                    valuePadding = 8,
                    valueSize = 15,
                    valueTextColor = TextColor,
                    alignText = "Left",
                )

                BlackNormalTextComponent(
                    valueText = nomeUsuario,
                    valuePadding = 8,
                    valueSize = 20,
                    valueTextColor = TextColor,
                    alignText = "Left",
                )

            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        )
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}