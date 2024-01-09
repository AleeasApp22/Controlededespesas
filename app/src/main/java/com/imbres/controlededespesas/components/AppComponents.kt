package com.imbres.controlededespesas.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imbres.controlededespesas.ui.theme.Primary
import com.imbres.controlededespesas.ui.theme.Secondary
import com.imbres.controlededespesas.ui.theme.robotoFontFamily

@Composable
fun NormalTitleTextComponent(valueText: String, valueSize: Int, valueTextColor: Color){
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
        textAlign = TextAlign.Left
    )
}

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

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false){
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        onClick = { onButtonClicked.invoke() },
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp)
            .background(
                brush = Brush.horizontalGradient(listOf(Secondary, Primary))
            ),
            contentAlignment = Alignment.Center){
            Text(text = value,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
    }
}
