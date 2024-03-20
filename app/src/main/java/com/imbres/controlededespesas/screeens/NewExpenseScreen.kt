package com.imbres.controlededespesas.screeens

import android.util.Log
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
import com.imbres.controlededespesas.components.ToastDisplay
import com.imbres.controlededespesas.data.login.LoginUIEvent
import com.imbres.controlededespesas.data.login.LoginViewModel
import com.imbres.controlededespesas.data.lostpassword.LostPasswordUIEvent
import com.imbres.controlededespesas.data.lostpassword.LostPasswordViewModel
import com.imbres.controlededespesas.data.model.CategoryParam
import com.imbres.controlededespesas.data.newexpense.NewExpenseViewModel
import com.imbres.controlededespesas.data.signup.SignupUIEvent
import com.imbres.controlededespesas.data.signup.SignupViewModel
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight

private var errorButton = false
private val TAG = NewExpenseViewModel::class.simpleName

@Composable
fun NewExpenseScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel = viewModel(),
    lostPasswordViewModel: LostPasswordViewModel = viewModel(),
    signupViewModel: SignupViewModel = viewModel(),
    categoryParam: CategoryParam
) {
    Log.d(TAG, "newExpense index: ${categoryParam.id}")
    Log.d(TAG, "newExpense category: ${categoryParam.name}")


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
                    valueText = stringResource(id = R.string.create_an_expense),
                    valuePadding = 8,
                    valueSize = 25,
                    valueHeightIn = 40,
                    valueTextColor = TextColor,
                    alignText = "Left",
                    true
                )

                NormalTitleTextComponent(
                    valueText = categoryParam.name,
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

                ClickableUnderLinedTextComponent(
                    stringResource(id = R.string.back),
                    onButtonClicked = {
                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
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
                    navController.navigate(Screen.Login.route)
                }
            }

            if (lostPasswordViewModel.lostPasswordInProgress.value) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    LoadingAnimation()
                }
            }

            if (lostPasswordViewModel.lostPasswordPass.value) {
                ToastDisplay(msg = stringResource(R.string.send_reset_password_email_ok))
                lostPasswordViewModel.lostPasswordPass.value = false
                loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
            }

            if (lostPasswordViewModel.lostPasswordFail.value) {
                ToastDisplay(msg = stringResource(R.string.invalid_email))
                lostPasswordViewModel.lostPasswordFail.value = false
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
fun NewExpenseScreenPreview() {
    val navController = rememberNavController()

    NewExpenseScreen(
        navController = navController,
        LoginViewModel(),
        LostPasswordViewModel(),
        SignupViewModel(),
        CategoryParam(0, "A")
    )
}