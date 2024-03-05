package com.imbres.controlededespesas.screeens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.imbres.controlededespesas.components.BlackNormalTextComponent
import com.imbres.controlededespesas.data.home.HomeViewModel
import com.imbres.controlededespesas.ui.theme.Primary
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight

private val TAG = HomeViewModel::class.simpleName

@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = viewModel()) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val userId: String
    val email: String
    var name: String
    //val usersParam = homeViewModel.getUserData()

    userId = ""
    email = "marcosgodoy0902@gmail.com"
    name = "Marcos"

    /*    userId = usersParam.value.userId
        email = usersParam.value.email
        name = usersParam.value.name*/

    /*
    Configurando a navegação com a BottomAppBar no App Android | Jetpack Compose
    https://www.youtube.com/watch?v=pcpq9bmacIs
    */

    Column(
        modifier = Modifier
            .background(greenFinLight)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.3f)
                .background(greenFinLight),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BlackNormalTextComponent(
                        //valueText = Saudacao(),
                        valueText = "Bom dia",
                        valuePadding = 8,
                        valueSize = 15,
                        valueHeightIn = 0,
                        valueTextColor = TextColor,
                        alignText = "Left",
                        false
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    Image(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "Notifications"
                    )

                }

                Column(

                ) {
                    BlackNormalTextComponent(
                        valueText = name,
                        valuePadding = 8,
                        valueSize = 20,
                        valueHeightIn = 0,
                        valueTextColor = TextColor,
                        alignText = "Left",
                        true
                    )

                    Row(
                        modifier = Modifier
                            .padding(start = 10.dp, end = 10.dp)
                        //.height(100.dp),
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.7f)
                                .clip(RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp))
                                .background(Primary)
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 10.dp),
                                text = "Teste"
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.7f)
                                .clip(RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp))
                                .background(Color.White)
                        ) {
                            Text(
                                modifier = Modifier
                                    .padding(start = 20.dp, top = 10.dp),
                                text = "Teste"
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.padding(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.7f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        ) {

            val navController = rememberNavController()
            val items = remember {
                listOf(
                    Pair("Home", Icons.Filled.Home),
                    Pair("Categorias", Icons.Filled.Category)
                )
            }
            var selectedItem by remember {
                mutableStateOf(items.first())
            }

            Column(Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController,
                    startDestination = "Home",
                    Modifier.weight(1f)
                ) {
                    composable("Home") {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Home",
                                Modifier.align(Alignment.Center),
                                fontSize = 64.sp
                            )
                        }
                    }
                    composable("Categorias") {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color.White)
                        ) {
                            Text(
                                text = "Categorias",
                                Modifier.align(Alignment.Center),
                                fontSize = 64.sp
                            )
                        }
                    }
                }
                BottomAppBar(actions = {
                    items.forEach { item ->
                        val text = item.first
                        val icon = item.second
                        NavigationBarItem(
                            selected = selectedItem == item,
                            onClick = {
                                selectedItem = item
                                val route = when (text) {
                                    "Home" -> "Home"
                                    "Categorias" -> "Categorias"
                                    else -> {
                                        ""
                                    }
                                }
                                navController.navigate(route, navOptions = navOptions {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.startDestinationId)
                                })
                            },
                            icon = {
                                Icon(icon, contentDescription = null)
                            },
                            label = {
                                Text(text = text)
                            }
                        )
                    }
                })
            }
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}