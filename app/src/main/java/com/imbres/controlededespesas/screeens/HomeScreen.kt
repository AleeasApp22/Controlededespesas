package com.imbres.controlededespesas.screeens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.imbres.controlededespesas.components.BlackNormalTextComponent
import com.imbres.controlededespesas.components.Saudacao
import com.imbres.controlededespesas.data.home.HomeViewModel
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight

private val TAG = HomeViewModel::class.simpleName

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
//    val (userId, email) = homeViewModel.getUserData()
//    val getData = homeViewModel.state.value
//    var name = getData.name
//    val stateUsersParam = homeViewModel.getUserData()
//    val (userId, email) = homeViewModel.getUserData()

    val userId : String
    val email : String
    var name : String
    val usersParam = homeViewModel.getUserData()

    userId = usersParam.value.userId
    email = usersParam.value.email
    name = usersParam.value.name

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
                    valueHeightIn = 0,
                    valueTextColor = TextColor,
                    alignText = "Left",
                )

                BlackNormalTextComponent(
                    valueText = name,
                    valuePadding = 8,
                    valueSize = 20,
                    valueHeightIn = 0,
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