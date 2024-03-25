package com.imbres.controlededespesas.components

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.data.NavigationItem
import com.imbres.controlededespesas.ui.theme.AccentColor
import com.imbres.controlededespesas.ui.theme.GrayColor
import com.imbres.controlededespesas.ui.theme.Primary
import com.imbres.controlededespesas.ui.theme.Secondary
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.robotoFontFamily
import java.util.Calendar

@Composable
fun NormalTitleTextComponent(
    valueText: String,
    valueSize: Int,
    valueTextColor: Color,
    alignText: String
) {
    Text(
        text = valueText,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        style = TextStyle(
            fontFamily = robotoFontFamily,
            fontSize = valueSize.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        color = valueTextColor,
        textAlign = if (alignText == "Left") TextAlign.Left else TextAlign.Center,
    )
}

@Composable
fun NormalTitleTextComponentOrientation(
    valueText: String,
    valueSize: Int,
    valueTextColor: Color,
    alignText: String
) {
    Text(
        text = valueText,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        style = TextStyle(
            fontFamily = robotoFontFamily,
            fontSize = valueSize.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        color = valueTextColor,
        textAlign = if (alignText == "Left") TextAlign.Left else TextAlign.Center,
    )
}

@Composable
fun BlackNormalTextComponent(
    valueText: String,
    valuePadding: Int,
    valueSize: Int,
    valueHeightIn: Int,
    valueTextColor: Color,
    alignText: String,
    fill: Boolean
) {
    Text(
        text = valueText,
        modifier = Modifier
            .then(if (fill) Modifier.fillMaxWidth() else Modifier)
            .padding(valuePadding.dp)
            .heightIn(min = valueHeightIn.dp),
        style = TextStyle(
            fontFamily = robotoFontFamily,
            fontSize = valueSize.sp,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
        ),
        color = valueTextColor,
        textAlign = if (alignText == "Left") TextAlign.Left else TextAlign.Center,
    )
}

@Composable
fun NormalTextComponent(value: String, size: Int, valueTextColor: Color) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontFamily = robotoFontFamily,
            fontSize = size.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
        ),
        color = valueTextColor,
        textAlign = TextAlign.Center
    )

}

/*
Request Focus on a TextField using Jetpack Compose
https://www.youtube.com/shorts/cXIN99PRgsc
*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(
    labelValue: String,
    painterResource: Painter,
    onTextChanged: (String) -> Unit,
    errorStatus: Boolean = false
) {
    val localFocusManager = LocalFocusManager.current

    val textValue = remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(

            focusedBorderColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
//            errorCursorColor = Color.Black,
//            errorBorderColor = Color.Black,
//            errorLabelColor = Color.Black,
            //backgroundColor = BgColor
        ),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,

        onValueChange = {
            textValue.value = it
            onTextChanged(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        isError = !errorStatus
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextFieldComponent(
    labelValue: String,
    painterResource: Painter,
    onTextSelected: (String) -> Unit,
    errorStatus: Boolean = false
) {
    val localFocusManager = LocalFocusManager.current

    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        //.clip(componentShapes.small),
        label = { Text(text = labelValue) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Gray,
            focusedLabelColor = Color.Gray,
            unfocusedBorderColor = Color.Gray,
            unfocusedLabelColor = Color.Gray,
//            cursorColor = Color.Black,
//            errorCursorColor = Color.Black,
//            errorBorderColor = Color.Black,
//            errorLabelColor = Color.Black,
//            errorPlaceholderColor = Color.Blue,
            //backgroundColor = BgColor
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        },
        maxLines = 1,
        value = password.value,

        onValueChange = {
            password.value = it
            onTextSelected(it)
        },
        leadingIcon = {
            Icon(painter = painterResource, contentDescription = "")
        },
        trailingIcon = {

            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible.value) {
                stringResource(id = com.imbres.controlededespesas.R.string.hide_password)
            } else {
                stringResource(id = com.imbres.controlededespesas.R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description, tint = Color.Black)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
        isError = !errorStatus
    )
}

@Composable
fun ClickableUnderLinedTextComponent(valueText: String, onButtonClicked: () -> Unit) {
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        ),


        text = AnnotatedString(valueText),
        onClick = { onButtonClicked.invoke() },
    )
}

@Composable
fun UnderLinedTextComponent(valueText: String) {
    Text(
        text = valueText,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), color = TextColor,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )

}

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = { onButtonClicked.invoke() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            Color.Transparent,
            Color.White,
            Color.Transparent,
            Color.Gray,
        ),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary))
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun ButtonComponentNoFill(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false) {
    Button(
        modifier = Modifier
            .heightIn(48.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = { onButtonClicked.invoke() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            Color.Transparent,
            Color.White,
            Color.Transparent,
            Color.Gray,
        ),
        enabled = isEnabled
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(listOf(Secondary, Primary))
                ),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun ButtonComponentCategories(
    value: String,
    onButtonClicked: () -> Unit,
    cores: List<Color>,
    index: Int
) {
    Button(
        modifier = Modifier
            .padding(
                start = 5.dp,
                end = 5.dp,
                bottom = 5.dp
            ),
        shape = RoundedCornerShape(10.dp),
        onClick = { onButtonClicked.invoke() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(cores[index]),
    ) {
        Box(
            modifier = Modifier
                .background(color = cores[index]),
            /*                .background(
                                brush = Brush.horizontalGradient(listOf(Secondary, Primary))
                            ),*/
            contentAlignment = Alignment.Center,
        ) {
            Text(
                modifier = Modifier
                    .padding(all = 5.dp),
                text = "$value",
                fontSize = 15.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,

                )
        }
    }

    Spacer(modifier = Modifier.height(10.dp))

}

@Composable
fun DividerTextComponent() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = Color.Gray,
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = stringResource(id = com.imbres.controlededespesas.R.string.ou),
            fontSize = 16.sp,
            color = TextColor
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = GrayColor,
            thickness = 1.dp
        )
    }
}

/*
    CircularProgressIndicator(
        color = TextColorGreenHeavy,
        trackColor = Color.Green,
        strokeCap = StrokeCap.Butt,
    )

*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    toolbarTitle: String, logoutButtonClicked: () -> Unit,
    navigationIconClicked: () -> Unit
) {

    TopAppBar(title = { /*TODO*/ })


    /*    TopAppBar(
            //backgroundColor = Primary,
            colors = colo,
            title = {
                Text(
                    text = toolbarTitle, color = WhiteColor
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navigationIconClicked.invoke()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Menu,
                        contentDescription = stringResource(R.string.menu),
                        tint = WhiteColor
                    )
                }

            },
            actions = {
                IconButton(onClick = {
                    logoutButtonClicked.invoke()
                }) {
                    Icon(
                        imageVector = Icons.Filled.Logout,
                        contentDescription = stringResource(id = R.string.logout),
                    )
                }
            }
        )*/
}

@Composable
fun NavigationDrawerHeader(value: String?) {
    Box(
        modifier = Modifier
            .background(
                Brush.horizontalGradient(
                    listOf(Primary, Secondary)
                )
            )
            .fillMaxWidth()
            .height(180.dp)
            .padding(32.dp)
    ) {

        NavigationDrawerText(
            title = value ?: stringResource(R.string.navigation_header), 28.sp, AccentColor
        )

    }
}

@Composable
fun NavigationDrawerBody(
    navigationDrawerItems: List<NavigationItem>,
    onNavigationItemClicked: (NavigationItem) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {

        items(navigationDrawerItems) {
            NavigationItemRow(item = it, onNavigationItemClicked)
        }

    }
}

@Composable
fun NavigationItemRow(
    item: NavigationItem,
    onNavigationItemClicked: (NavigationItem) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onNavigationItemClicked.invoke(item)
            }
            .padding(all = 16.dp)
    ) {

        Icon(
            imageVector = item.icon,
            contentDescription = item.description,
        )

        Spacer(modifier = Modifier.width(18.dp))

        NavigationDrawerText(title = item.title, 18.sp, Primary)
    }
}

@Composable
fun NavigationDrawerText(title: String, textUnit: TextUnit, color: Color) {

    val shadowOffset = Offset(4f, 6f)

    Text(
        text = title, style = TextStyle(
            color = Color.Black,
            fontSize = textUnit,
            fontStyle = FontStyle.Normal,
            shadow = Shadow(
                color = Primary,
                offset = shadowOffset, 2f
            )
        )
    )
}

@Composable
fun ToastDisplay(msg: String) {
    val ctx = LocalContext.current
    Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show()

}

/*
Caixas de diálogo
https://developer.android.com/develop/ui/views/components/dialogs?hl=pt-br
*/

@Composable
fun AlertDisplay(context: Context, tit: String, msg: String, pos: String, neg: String) {
    val builder: AlertDialog.Builder = AlertDialog.Builder(context)


    val title = if (tit.isEmpty()) "" else tit
    val positive = if (pos.isEmpty()) "" else pos
    val negative = if (neg.isEmpty()) "" else neg

    builder
        .setTitle(title)
        .setMessage(msg)
        .setPositiveButton(positive) { dialog, which ->
            // Do something.
        }
        .setNegativeButton(negative) { dialog, which ->
            // Do something else.
        }

    val dialog: AlertDialog = builder.create()
    dialog.show()
}

fun Saudacao(): String {
    val horaAtual = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    var saudacao = "Saudação"

    when (horaAtual) {
        in 0..11 -> saudacao = "Bom dia,"
        in 12..17 -> saudacao = "Boa tarde,"
        in 18..23 -> saudacao = "Boa noite,"
    }

    return saudacao
}