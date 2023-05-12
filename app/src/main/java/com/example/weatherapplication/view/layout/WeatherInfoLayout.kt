package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.view_model.MainActivityViewModel

@Composable
fun WeatherInfo(
    viewModel: MainActivityViewModel
) {
    val windSpeed: String = "10 m/s"
    val humidity: String = "98 %"
    val rainProbability: String = "100%"
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(10.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        WeatherInfoComponent(
            modifier = Modifier.weight(1f),
            dataText = windSpeed,
            descriptionText = "Wind",
            iconID = com.example.weatherapplication.R.drawable.round_air_24
        )
        WeatherInfoComponent(
            modifier = Modifier.weight(1f),
            dataText = humidity,
            descriptionText = "Humidity",
            iconID = com.example.weatherapplication.R.drawable.round_water_drop_24
        )
        WeatherInfoComponent(
            modifier = Modifier.weight(1f),
            dataText = rainProbability,
            descriptionText = "Rain",
            iconID = com.example.weatherapplication.R.drawable.round_thunderstorm_24
        )
    }
}

@Composable
fun WeatherInfoComponent(
    modifier: Modifier,
    dataText: String,
    descriptionText: String,
    iconID: Int
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .padding(bottom = 5.dp)
                .size(40.dp),
            imageVector = ImageVector.vectorResource(id = iconID),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground
        )
        Text(
            text = dataText,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground
        )
        Text(
            text = descriptionText,
            fontSize = 12.sp,
            color = MaterialTheme.colors.onSurface
        )
    }
}