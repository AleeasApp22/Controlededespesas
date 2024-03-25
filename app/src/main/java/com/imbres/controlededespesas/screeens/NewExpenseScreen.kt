package com.imbres.controlededespesas.screeens

import android.app.DatePickerDialog
import android.os.Build
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.imbres.controlededespesas.components.ButtonComponentNoFill
import com.imbres.controlededespesas.components.ClickableUnderLinedTextComponent
import com.imbres.controlededespesas.components.DividerTextComponent
import com.imbres.controlededespesas.components.LoadingAnimation
import com.imbres.controlededespesas.components.MyTextFieldComponent
import com.imbres.controlededespesas.components.MyTextFieldComponentWithValue
import com.imbres.controlededespesas.components.NormalTitleTextComponent
import com.imbres.controlededespesas.data.model.CategoryParam
import com.imbres.controlededespesas.data.newexpense.NewExpenseUIEvent
import com.imbres.controlededespesas.data.newexpense.NewExpenseViewModel
import com.imbres.controlededespesas.data.signup.SignupUIEvent
import com.imbres.controlededespesas.navigation.Screen
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.greenFinLight
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date

private var errorButton = false
private val TAG = NewExpenseViewModel::class.simpleName

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NewExpenseScreen(
    navController: NavHostController,
    newExpenseViewModel: NewExpenseViewModel = viewModel(),
    categoryParam: CategoryParam,
    context: android.content.Context
) {

    // Date Picker With Jetpack Compose in Android Studio
    // https://www.youtube.com/watch?v=cJxo96eTHVU

    val year: Int
    val month: Int
    val day: Int

    val calendar = Calendar.getInstance()
    year = calendar.get(Calendar.YEAR)
    month = calendar.get(Calendar.MONTH)
    day = calendar.get(Calendar.DAY_OF_MONTH)
    calendar.time = Date()

    val date = remember { mutableStateOf("") }
    val datePickerDialog = DatePickerDialog(
        context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/${month + 1}/$year"
        }, year, month, day
    )
    val dateNow = LocalDate.now()
    val formattedDate = dateNow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))

    Column(
        modifier = Modifier.background(greenFinLight),
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
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
            ) {
/*                BlackNormalTextComponent(
                    valueText = "${stringResource(id = R.string.date_purchase)}: ${date.value}",
                    valuePadding = 8,
                    valueSize = 20,
                    valueHeightIn = 40,
                    valueTextColor = TextColor,
                    alignText = "Center",
                    true
                )*/

                MyTextFieldComponentWithValue(
                    labelValue = stringResource(id = R.string.date_purchase),
                    date,
                    painterResource(id = R.drawable.message),
                    onTextChanged = {
                        //signUpViewModel.onEvent(SignupUIEvent.NameChanged(it))
                    },
                    //errorStatus = signUpViewModel.signupUIState.value.nameError
                )
                //errorButton = signUpViewModel.signupUIState.value.nameError

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .weight(0.5f)
                    ) {
                        Column(
                        ) {
                            ButtonComponentNoFill(
                                value = stringResource(id = R.string.today),
                                onButtonClicked = { date.value = formattedDate },
                                isEnabled = true
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(20.dp))

                    Box(
                        modifier = Modifier
                            .weight(0.5f)
                    ) {
                        Column(
                        ) {
                            ButtonComponentNoFill(
                                value = stringResource(id = R.string.select_a_date),
                                onButtonClicked = { datePickerDialog.show() },
                                isEnabled = true
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                ButtonComponent(
                    value = stringResource(id = R.string.validar),
                    onButtonClicked = {
                        //lostPasswordViewModel.onEvent(LostPasswordUIEvent.LostPasswordButtonClicked)
                        newExpenseViewModel.onEvent(NewExpenseUIEvent.NewExpenseButtonClicked)
                    },
                    //isEnabled = if (errorButton) lostPasswordViewModel.allValidationsPassed.value else false
                )

                Spacer(modifier = Modifier.height(40.dp))

                DividerTextComponent()

                Spacer(modifier = Modifier.height(40.dp))

                ClickableUnderLinedTextComponent(
                    stringResource(id = R.string.back),
                    onButtonClicked = {
                        newExpenseViewModel.onEvent(NewExpenseUIEvent.NewExpenseReturnButtonClicked)
                    },
                )
            }

        }

        if (newExpenseViewModel.newExpenseReturnInProgress.value) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                LoadingAnimation()
                navController.navigate(Screen.Home.route)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewExpenseScreenPreview() {
    val navController = rememberNavController()
    val context = LocalContext.current

    NewExpenseScreen(
        navController = navController, categoryParam = CategoryParam(0, "A"), context = context
    )
}
