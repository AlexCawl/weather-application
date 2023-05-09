package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.view_model.WeatherViewModel

@Composable
fun WeatherInfo(
    viewModel: WeatherViewModel
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
            descriptionText = "Wind"
        )
        WeatherInfoComponent(
            modifier = Modifier.weight(1f),
            dataText = humidity,
            descriptionText = "Humidity"
        )
        WeatherInfoComponent(
            modifier = Modifier.weight(1f),
            dataText = rainProbability,
            descriptionText = "Rain"
        )
    }
}

@Composable
fun WeatherInfoComponent(
    modifier: Modifier,
    dataText: String,
    descriptionText: String
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
            imageVector = Icons.Default.Search,
            contentDescription = null
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