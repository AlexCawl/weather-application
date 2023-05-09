package com.example.weatherapplication.view.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.view_model.WeatherViewModel

@Composable
fun TemperatureInfo(
    viewModel: WeatherViewModel
) {
    val temperature: String = "18°"
    val weatherDescription: String = "Thunderstorm"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = temperature,
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.onBackground
            )
            Text(
                text = weatherDescription,
                fontSize = 14.sp,
                color = MaterialTheme.colors.onSurface
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize(),
            imageVector = Icons.Default.Search,
            contentDescription = null
        )
    }
}