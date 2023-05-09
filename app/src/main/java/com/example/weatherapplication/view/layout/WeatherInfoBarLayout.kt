package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WeatherInfoBar() {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherInfo(
            modifier = Modifier.weight(1f),
            dataText = "10 m/s",
            descriptionText = "Wind"
        )
        WeatherInfo(
            modifier = Modifier.weight(1f),
            dataText = "98 %",
            descriptionText = "Humidity"
        )
        WeatherInfo(
            modifier = Modifier.weight(1f),
            dataText = "100 %",
            descriptionText = "Rain"
        )
    }
}