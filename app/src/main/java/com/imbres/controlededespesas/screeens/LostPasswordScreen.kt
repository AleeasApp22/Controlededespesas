package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.components.BlackNormalTextComponent
import com.imbres.controlededespesas.components.ButtonComponent
import com.imbres.controlededespesas.components.ClickableUnderLinedTextComponent
import com.imbres.controlededespesas.components.DividerTextComponent
import com.imbres.controlededespesas.components.LoadingAnimation
import com.imbres.controlededespesas.components.MyTextFieldComponent
import com.imbres.controlededespesas.components.NormalTitleTextComponent
import com.imbres.controlededespesas.data.login.LoginUIEvent
import com.imbres.controlededespesas.data.login.LoginViewModel
import com.imbres.controlededespesas.data.lostpassword.LostPasswordUIEvent
import com.imbres.controlededespesas.data.lostpassword.LostPasswordViewModel
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight

private var errorButton = false


@Composable
fun LostPasswordScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = viewModel(),
    lostPasswordViewModel: LostPasswordViewModel = viewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = greenFinLight
        ) {
            Column(
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {

                BlackNormalTextComponent(
                    valueText = stringResource(id = R.string.recovery_password),
                    valuePadding = 8,
                    valueSize = 25,
                    valueTextColor = TextColor,
                    alignText = "Left"
                )

                NormalTitleTextComponent(
                    valueText = stringResource(id = R.string.change_password),
                    valueSize = 20,
                    valueTextColor = TextColor,
                    alignText = "Left"
                )
            }
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(5f),
            color = Color.Green
        ) {
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
                                cornerRadius = CornerRadius(30.dp.toPx())
                            )
                        }
                    }
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, top = 40.dp, end = 20.dp)
                ) {

                    MyTextFieldComponent(
                        labelValue = stringResource(id = R.string.email),
                        painterResource(id = R.drawable.message),
                        onTextChanged = {
                            lostPasswordViewModel.onEvent(LostPasswordUIEvent.EmailChanged(it))
                        },
                        errorStatus = lostPasswordViewModel.lostPaswordUIState.value.emailError
                    )
                    errorButton = lostPasswordViewModel.lostPaswordUIState.value.emailError

                    Spacer(modifier = Modifier.height(20.dp))

                    ButtonComponent(
                        value = stringResource(id = R.string.validar),
                        onButtonClicked = {
                            lostPasswordViewModel.onEvent(LostPasswordUIEvent.LostPasswordButtonClicked)
                        },
                        isEnabled = if (errorButton) lostPasswordViewModel.allValidationsPassed.value else false
                    )

                    Spacer(modifier = Modifier.height(40.dp))

                    DividerTextComponent()

                    Spacer(modifier = Modifier.height(40.dp))

/*                    UnderLinedTextComponent(
                        valueText = stringResource(id = R.string.back),
                        )*/

                    ClickableUnderLinedTextComponent(
                        stringResource(id = R.string.back),
                        onButtonClicked = {
                            loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                        },
                    )
                }
            }

            if (loginViewModel.loginInProgress.value) {
                Column(
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    navController.popBackStack()
                    navController.navigate(Screen.Login.route)
                }
            }

            if (lostPasswordViewModel.lostPasswordInProgress.value) {
                Column(
                    modifier = Modifier
                        .height(70.dp)
                        .width(70.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    //navController.popBackStack()
                    LoadingAnimation()
                }
            }

        }

        /*SystemBackButtonHandler {
            PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
        }*/

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = greenFinLight
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp, end = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                BlackNormalTextComponent(
                    valueText = stringResource(id = R.string.sign_up_account),
                    valuePadding = 0,
                    valueSize = 18,
                    valueTextColor = TextColor,
                    alignText = "Center"
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LostPasswordScreenPreview() {

    val navController = rememberNavController()
    LostPasswordScreen(navController = navController)

}