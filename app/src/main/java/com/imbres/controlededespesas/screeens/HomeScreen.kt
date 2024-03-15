package com.imbres.controlededespesas.screeens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material.icons.filled.GroupAdd
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.components.BlackNormalTextComponent
import com.imbres.controlededespesas.components.ButtonComponentCategories
import com.imbres.controlededespesas.components.NormalTitleTextComponent
import com.imbres.controlededespesas.components.Saudacao
import com.imbres.controlededespesas.data.home.HomeViewModel
import com.imbres.controlededespesas.data.newexpense.NewExpenseUIEvent
import com.imbres.controlededespesas.data.newexpense.NewExpenseViewModel
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight
import com.imbres.controlededespesas.ui.theme.greenFingreenFinHeavy
import com.imbres.controlededespesas.ui.theme.robotoFontFamily
import com.imbres.controlededespesas.ui.theme.tagBlack
import com.imbres.controlededespesas.ui.theme.tagBlue
import com.imbres.controlededespesas.ui.theme.tagGreen
import com.imbres.controlededespesas.ui.theme.tagGreenHeavy
import com.imbres.controlededespesas.ui.theme.tagGreenLemon
import com.imbres.controlededespesas.ui.theme.tagOrange
import com.imbres.controlededespesas.ui.theme.tagPink
import com.imbres.controlededespesas.ui.theme.tagPinkHard
import com.imbres.controlededespesas.ui.theme.tagPurple
import com.imbres.controlededespesas.ui.theme.tagRed
import com.imbres.controlededespesas.ui.theme.tagSkyBlue
import com.imbres.controlededespesas.ui.theme.tagYellow

private val TAG = HomeViewModel::class.simpleName

@OptIn(ExperimentalLayoutApi::class)
@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(
    navController: NavHostController,
    newExpenseViewModel: NewExpenseViewModel = viewModel(),
) {

    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val userId: String
    val email: String
    var name: String

    /*
        val usersParam = homeViewModel.getUserData()

        userId = usersParam.value.userId
        email = usersParam.value.email
        name = usersParam.value.name
    */


    userId = ""
    email = "marcosgodoy0902@gmail.com"
    name = "Marcos"


    /*
    Configurando a navegação com a BottomAppBar no App Android | Jetpack Compose
    https://www.youtube.com/watch?v=pcpq9bmacIs
    */

    Column(
        modifier = Modifier.background(greenFinLight)
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
                        valueText = Saudacao(),
                        //valueText = "Bom dia",
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
                        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .weight(0.6f)
                                .clip(RoundedCornerShape(topStart = 30.dp, bottomStart = 30.dp))
                                .background(greenFingreenFinHeavy),
                        ) {
                            Row(
                                modifier = Modifier.padding(
                                    start = 10.dp, top = 10.dp, end = 10.dp
                                ), verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Circle,
                                    contentDescription = "Notifications",
                                    tint = Color.Green,
                                )

                                NormalTitleTextComponent(
                                    valueText = stringResource(id = R.string.user_status_log),
                                    valueSize = 15,
                                    valueTextColor = greenFinLight,
                                    alignText = "Left"
                                )

                            }

                            Column(
                                modifier = Modifier.padding(start = 10.dp, top = 40.dp)
                            ) {
                                NormalTitleTextComponent(
                                    valueText = "Jan: ${stringResource(id = R.string.balance)}",
                                    valueSize = 15,
                                    valueTextColor = Color.White,
                                    alignText = "Left"
                                )

                                NormalTitleTextComponent(
                                    valueText = "Fev: ${stringResource(id = R.string.balance)}",
                                    valueSize = 20,
                                    valueTextColor = Color.White,
                                    alignText = "Left"
                                )

                                BlackNormalTextComponent(
                                    valueText = "Mar: ${stringResource(id = R.string.balance)}",
                                    valuePadding = 8,
                                    valueSize = 25,
                                    valueHeightIn = 0,
                                    valueTextColor = Color.White,
                                    alignText = "Left",
                                    true
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(50.dp)
                                .height(50.dp)
                                .weight(0.4f)
                                .clip(RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp))
                                .background(Color.White)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth()
                            ) {

                                BlackNormalTextComponent(
                                    valueText = stringResource(id = R.string.last_purchase),
                                    valuePadding = 8,
                                    valueSize = 20,
                                    valueHeightIn = 0,
                                    valueTextColor = Color.Black,
                                    alignText = "Left",
                                    true
                                )

                                NormalTitleTextComponent(
                                    valueText = stringResource(id = R.string.category),
                                    valueSize = 20,
                                    valueTextColor = Color.Black,
                                    alignText = "Left"
                                )

                                NormalTitleTextComponent(
                                    valueText = stringResource(id = R.string.date),
                                    valueSize = 15,
                                    valueTextColor = Color.Black,
                                    alignText = "Left"
                                )

                                NormalTitleTextComponent(
                                    valueText = stringResource(id = R.string.balance),
                                    valueSize = 15,
                                    valueTextColor = Color.Black,
                                    alignText = "Left"
                                )
                            }
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
                    Pair("Categorias", Icons.Filled.Category),
                    Pair("Perfil", Icons.Filled.Person)
                )
            }
            var selectedItem by remember {
                mutableStateOf(items.first())
            }

            Row(
                Modifier
                    .background(greenFingreenFinHeavy),
            ) {
                Column(
                ) {
                    Text(
                        text = stringResource(id = R.string.function),
                        modifier = Modifier
                            .padding(all = 5.dp)
                            .fillMaxWidth(),
                        style = TextStyle(
                            fontFamily = robotoFontFamily,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Black,
                            fontStyle = FontStyle.Normal,
                        ),
                        color = greenFinLight,
                        textAlign = TextAlign.Center
                    )
                }

            }

            Column(Modifier.fillMaxSize()) {
                NavHost(
                    navController = navController, startDestination = "Home", Modifier.weight(1f)
                ) {
                    composable("Home") {

                        Column(
                            Modifier
                                .padding(top = 30.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            val categories = listOf(
                                "Padaria, lanches, bebidas",
                                "Empréstimos, tarifas, taxas, IR e impostos",
                                "Despesas com transporte (Combustível, Sem Parar, oficina, licenciamento)",
                                "NÃO CONTABILIZADO",
                                "Internet, Celular, TV, site, spotify, hospedagem digital, impressora, email",
                                "Vestuário, ensino, cuidados",
                                "Supermercado, sacolão, açougue, feira",
                                "Seguros",
                                "Cacao",
                                "Saúde (Unimed, Uniodonto, Medicamentos)",
                                "EDP, Sabesp, gás, IPTU, empregada, manutenção casa",
                                "Outros gastos"
                            )

                            val cores = listOf(
                                tagGreen, tagYellow, tagOrange, tagRed, tagPurple,
                                tagBlue, tagSkyBlue, tagGreenLemon, tagPinkHard, tagPink,
                                tagBlack, tagGreenHeavy,
                            )
                            /*
                        FlowRow()
                        https://developer.android.com/jetpack/compose/layouts/flow?hl=pt-br

                        [COMPOSE ROWS, COLUMNS, BOXES] COMO CRIAR LAYOUT EM JETPACK COMPOSE NO ANDROID
                        https://www.youtube.com/watch?v=ov8iCd7UDpw

                        JETPACK COMPOSE: Criando linhas e colunas flexíveis com Flow Layout
                        https://www.youtube.com/watch?v=ljux8p2RXsY

                        Scroll modifiers
                        https://developer.android.com/jetpack/compose/touch-input/pointer-input/scroll?hl=pt-br
                         */


                            /*                            Text(
                                                            text = stringResource(id = R.string.new_purchase),
                                                            modifier = Modifier
                                                                .padding(all = 10.dp)
                                                                .fillMaxWidth(),
                                                            style = TextStyle(
                                                                fontFamily = robotoFontFamily,
                                                                fontSize = 15.sp,
                                                                fontWeight = FontWeight.Black,
                                                                fontStyle = FontStyle.Normal,
                                                            ),
                                                            color = TextColor,
                                                            textAlign = TextAlign.Center
                                                        )*/
                            FlowRow(
                                modifier = Modifier
                                    .verticalScroll(rememberScrollState(), true, null, false)
                                    .weight(0.8f),
                                horizontalArrangement = Arrangement.Center,
                                verticalArrangement = Arrangement.SpaceEvenly,
                                maxItemsInEachRow = 4
                            ) {
                                categories.forEachIndexed { index, category ->
                                    ButtonComponentCategories(
                                        value = category,
                                        onButtonClicked = {
                                            newExpenseViewModel.onEvent(NewExpenseUIEvent.NewExpenseButtonClicked)
                                        },
                                        cores,
                                        index,
                                    )
                                }
                            }
                        }
                    }
                    composable("Categorias") {
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            NormalTitleTextComponent(
                                valueText = stringResource(id = R.string.categories),
                                valueSize = 20,
                                valueTextColor = TextColor,
                                alignText = "Center"
                            )
                            Row(
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .background(Color.White)
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .width(130.dp)
                                            .height(130.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    topStart = 30.dp,
                                                    bottomStart = 30.dp,
                                                    bottomEnd = 30.dp,
                                                    topEnd = 30.dp
                                                )
                                            )
                                            .background(Color.LightGray),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(
                                                start = 10.dp, top = 10.dp, end = 10.dp
                                            ),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Icon(
                                                modifier = Modifier
                                                    .width(50.dp)
                                                    .height(50.dp),
                                                imageVector = Icons.Filled.Category,
                                                contentDescription = "New category",
                                                tint = Color.DarkGray,
                                            )

                                            NormalTitleTextComponent(
                                                valueText = stringResource(id = R.string.new_category),
                                                valueSize = 15,
                                                valueTextColor = TextColor,
                                                alignText = "Center"
                                            )
                                        }
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .background(Color.White)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .width(130.dp)
                                            .height(130.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    topStart = 30.dp,
                                                    bottomStart = 30.dp,
                                                    bottomEnd = 30.dp,
                                                    topEnd = 30.dp
                                                )
                                            )
                                            .background(Color.LightGray),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(
                                                start = 10.dp, top = 10.dp, end = 10.dp
                                            ),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Icon(
                                                modifier = Modifier
                                                    .width(50.dp)
                                                    .height(50.dp),
                                                imageVector = Icons.Filled.FindInPage,
                                                contentDescription = "New category",
                                                tint = Color.DarkGray,
                                            )

                                            NormalTitleTextComponent(
                                                valueText = stringResource(id = R.string.find_category),
                                                valueSize = 15,
                                                valueTextColor = TextColor,
                                                alignText = "Center"
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    composable("Perfil") {
                        Column(
                            verticalArrangement = Arrangement.Center
                        ) {
                            NormalTitleTextComponent(
                                valueText = stringResource(id = R.string.profile),
                                valueSize = 20,
                                valueTextColor = TextColor,
                                alignText = "Center"
                            )
                            Row(
                                modifier = Modifier
                                    .padding(top = 30.dp)
                                    .fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceAround,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .background(Color.White)
                                ) {

                                    Box(
                                        modifier = Modifier
                                            .width(130.dp)
                                            .height(130.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    topStart = 30.dp,
                                                    bottomStart = 30.dp,
                                                    bottomEnd = 30.dp,
                                                    topEnd = 30.dp
                                                )
                                            )
                                            .background(Color.LightGray),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(
                                                start = 10.dp, top = 10.dp, end = 10.dp
                                            ),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Icon(
                                                modifier = Modifier
                                                    .width(50.dp)
                                                    .height(50.dp),
                                                imageVector = Icons.Filled.AccountBox,
                                                contentDescription = "My data",
                                                tint = Color.DarkGray,
                                            )

                                            NormalTitleTextComponent(
                                                valueText = stringResource(id = R.string.update_data),
                                                valueSize = 15,
                                                valueTextColor = TextColor,
                                                alignText = "Center"
                                            )
                                        }
                                    }
                                }

                                Box(
                                    modifier = Modifier
                                        .padding(all = 10.dp)
                                        .background(Color.White)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .width(130.dp)
                                            .height(130.dp)
                                            .clip(
                                                RoundedCornerShape(
                                                    topStart = 30.dp,
                                                    bottomStart = 30.dp,
                                                    bottomEnd = 30.dp,
                                                    topEnd = 30.dp
                                                )
                                            )
                                            .background(Color.LightGray),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(
                                                start = 10.dp, top = 10.dp, end = 10.dp
                                            ),
                                            verticalArrangement = Arrangement.Center,
                                            horizontalAlignment = Alignment.CenterHorizontally
                                        ) {
                                            Icon(
                                                modifier = Modifier
                                                    .width(50.dp)
                                                    .height(50.dp),
                                                imageVector = Icons.Filled.GroupAdd,
                                                contentDescription = "New users",
                                                tint = Color.DarkGray,
                                            )

                                            NormalTitleTextComponent(
                                                valueText = stringResource(id = R.string.new_users),
                                                valueSize = 15,
                                                valueTextColor = TextColor,
                                                alignText = "Center"
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }

                BottomAppBar(
                    containerColor = greenFinLight,
                    actions = {
                        items.forEach { item ->
                            val text = item.first
                            val icon = item.second
                            NavigationBarItem(selected = selectedItem == item, onClick = {
                                selectedItem = item
                                val route = when (text) {
                                    "Home" -> "Home"
                                    "Categorias" -> "Categorias"
                                    "Perfil" -> "Perfil"
                                    else -> {
                                        ""
                                    }
                                }
                                navController.navigate(route, navOptions = navOptions {
                                    launchSingleTop = true
                                    popUpTo(navController.graph.startDestinationId)
                                })
                            }, icon = {
                                Icon(icon, contentDescription = null)
                            }, label = {
                                Text(text = text)
                            })
                        }
                    })
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()

    HomeScreen(navController)
}