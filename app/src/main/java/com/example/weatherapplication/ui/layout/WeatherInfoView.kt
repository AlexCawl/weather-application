package com.example.weatherapplication.ui.layout

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
import com.example.weatherapplication.model.Forecast
import com.example.weatherapplication.ui.item.WeatherMetricaItem

@Composable
fun WeatherInfoView(
    forecast: Forecast,
    weatherSpeedRepresentationFunction: (Forecast) -> String,
    humidityRepresentationFunction: (Forecast) -> String,
    cloudinessRepresentationFunction: (Forecast) -> String,
) {
    val windSpeed: String = weatherSpeedRepresentationFunction(forecast)
    val humidity: String = humidityRepresentationFunction(forecast)
    val cloudiness: String = cloudinessRepresentationFunction(forecast)

    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherMetricaItem(
            modifier = Modifier.weight(1f),
            dataText = windSpeed,
            descriptionText = "Wind",
            iconID = com.example.weatherapplication.R.drawable.round_air_24
        )
        WeatherMetricaItem(
            modifier = Modifier.weight(1f),
            dataText = humidity,
            descriptionText = "Humidity",
            iconID = com.example.weatherapplication.R.drawable.round_water_drop_24
        )
        WeatherMetricaItem(
            modifier = Modifier.weight(1f),
            dataText = cloudiness,
            descriptionText = "Cloudiness",
            iconID = com.example.weatherapplication.R.drawable.round_cloud_24
        )
    }
}

