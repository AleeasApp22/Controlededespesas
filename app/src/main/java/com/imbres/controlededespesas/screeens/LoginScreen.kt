package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.imbres.controlededespesas.components.PasswordTextFieldComponent
import com.imbres.controlededespesas.components.ToastDisplay
import com.imbres.controlededespesas.data.login.LoginUIEvent
import com.imbres.controlededespesas.data.login.LoginViewModel
import com.imbres.controlededespesas.data.lostpassword.LostPasswordUIEvent
import com.imbres.controlededespesas.data.lostpassword.LostPasswordViewModel
import com.imbres.controlededespesas.data.signup.SignupUIEvent
import com.imbres.controlededespesas.data.signup.SignupViewModel
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight

private var errorButton = false

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = viewModel(),
    lostPasswordViewModel: LostPasswordViewModel = viewModel(),
    signupViewModel: SignupViewModel = viewModel(),
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(greenFinLight),
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.2f)
                .background(greenFinLight)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 10.dp, end = 10.dp),
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                BlackNormalTextComponent(
                    valueText = stringResource(id = R.string.bem_vindo),
                    valuePadding = 8,
                    valueSize = 25,
                    valueHeightIn = 40,
                    valueTextColor = TextColor,
                    alignText = "Left",
                    true
                )

                NormalTitleTextComponent(
                    valueText = stringResource(id = R.string.login_account),
                    valueSize = 20,
                    valueTextColor = TextColor,
                    alignText = "Left"
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 20.dp, top = 40.dp, end = 20.dp),
            ) {
                MyTextFieldComponent(
                    labelValue = stringResource(id = R.string.email),
                    painterResource(id = R.drawable.message),
                    onTextChanged = {
                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.emailError
                )
                errorButton = loginViewModel.loginUIState.value.emailError

                Spacer(modifier = Modifier.height(20.dp))

                PasswordTextFieldComponent(
                    labelValue = stringResource(id = R.string.password),
                    painterResource(id = R.drawable.lock),
                    onTextSelected = {
                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
                    },
                    errorStatus = loginViewModel.loginUIState.value.passwordError
                )
                errorButton = loginViewModel.loginUIState.value.passwordError

                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.login),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                    },
                    isEnabled = if (errorButton) loginViewModel.allValidationsPassed.value else false
                )

                Spacer(modifier = Modifier.height(40.dp))

                DividerTextComponent()

                Spacer(modifier = Modifier.height(40.dp))

                ClickableUnderLinedTextComponent(
                    stringResource(id = R.string.lost_password),
                    onButtonClicked = {
                        lostPasswordViewModel.onEvent(LostPasswordUIEvent.LostPasswordButtonClicked)
                    },
                )

                Spacer(modifier = Modifier.height(40.dp))

                ClickableUnderLinedTextComponent(
                    stringResource(id = R.string.sign_up_account),
                    onButtonClicked = {
                        signupViewModel.onEvent(SignupUIEvent.SignupButtonClicked)
                    },
                )
            }

            if (loginViewModel.loginInProgress.value) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    LoadingAnimation()
                    loginViewModel.allValidationsPassed.value = false
                }
            }

            if (loginViewModel.loginSucess.value) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    LoadingAnimation()
                    loginViewModel.loginSucess.value = false
                    navController.navigate(Screen.Home.route)
                }
            }

            if (loginViewModel.loginFail.value) {
                ToastDisplay(msg = stringResource(R.string.invalid_email_senha))
                loginViewModel.loginFail.value = false
            }

            if (lostPasswordViewModel.lostPasswordInProgress.value) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    LoadingAnimation()
                    navController.navigate(Screen.LostPassword.route)
                }
            }

            if (signupViewModel.signUpInProgress.value) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    LoadingAnimation()
                }
                navController.navigate(Screen.SignUp.route)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()

    LoginScreen(navController = navController)
}