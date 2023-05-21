package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.model.data.Forecast

@Composable
fun TemperatureInfoView(
    forecast: Forecast,
    temperatureRepresentationFunction: (Forecast) -> String,
    weatherTypeRepresentationFunction: (Forecast) -> String,
    iconRepresentationFunction: (Forecast) -> Int
) {
    val temperature: String = temperatureRepresentationFunction(forecast)
    val weatherDescription: String = weatherTypeRepresentationFunction(forecast)
    val iconID: Int = iconRepresentationFunction(forecast)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.padding(start = 50.dp),
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
        Icon(
            modifier = Modifier.size(150.dp),
            painter = painterResource(id = iconID),
            contentDescription = null
        )
    }
}