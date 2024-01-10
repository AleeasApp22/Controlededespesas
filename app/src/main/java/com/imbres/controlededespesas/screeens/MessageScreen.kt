package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imbres.controlededespesas.R
import com.imbres.controlededespesas.components.BlackNormalTextComponent
import com.imbres.controlededespesas.components.ButtonComponent
import com.imbres.controlededespesas.components.NormalTextComponent
import com.imbres.controlededespesas.ui.theme.TextColor
import com.imbres.controlededespesas.ui.theme.TextColorGreenHeavy

@Composable
fun MessageScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(12.dp)
    ) {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_main),
                contentDescription = "Controle de despesas",
                Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            BlackNormalTextComponent(valueText = stringResource(id = R.string.bem_vindo_ao), valueSize = 35, valueTextColor = TextColor)

            NormalTextComponent(value = stringResource(id = R.string.controle_despesas), size = 25, valueTextColor = TextColorGreenHeavy)

            Spacer(modifier = Modifier.height(80.dp))

            ButtonComponent(
                value = stringResource(id = R.string.iniciar),
                onButtonClicked = {  },
                isEnabled = true
            )

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MessageScreenPreview(){
    MessageScreen()
}