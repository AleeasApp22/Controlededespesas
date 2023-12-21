package com.imbres.controlededespesas.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imbres.controlededespesas.ui.theme.finish.theme.TextColor
import com.imbres.controlededespesas.ui.theme.finish.theme.robotoFontFamily

@Composable
fun BlackNormalTextComponent(value: String, size: Int, valueTextColor: Color){
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontFamily = robotoFontFamily,
            fontSize = size.sp,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Normal,
        ),
        color = valueTextColor,
        textAlign = TextAlign.Center
    )
}

@Composable
fun NormalTextComponent(value: String, size: Int, valueTextColor: Color){
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

