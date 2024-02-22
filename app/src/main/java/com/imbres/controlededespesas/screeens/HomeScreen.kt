package com.imbres.controlededespesas.screeens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.model.content.CircleShape
import com.imbres.controlededespesas.ui.theme.greenFinLight
import com.nativemobilebits.loginflow.data.home.HomeViewModelOld

@Composable
fun HomeScreen(homeViewModel: HomeViewModelOld = viewModel()) {
    Column {
        // Área superior com 60% da altura
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .background(greenFinLight)
        )

        // Área inferior com altura flexível e bordas curvas
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.5f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
        )
    }

}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}