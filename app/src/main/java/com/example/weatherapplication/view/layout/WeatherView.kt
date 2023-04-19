package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.R
import com.example.weatherapplication.model.data.CurrentWeather
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.view_model.WeatherViewModel

@Composable
fun WeatherView(
    weatherManager: WeatherViewModel
) {
    val location: Location? by remember { weatherManager.currentLocation }
    val weather: CurrentWeather? by remember { weatherManager.currentWeather }

    if (location != null && weather != null) {
        LocationInfoView(location = location!!)
    }
}

@Composable
fun LocationInfoView(
    location: Location
) {
    Column {
        LocationNameView(modifier = Modifier.fillMaxWidth(), location = location)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LocationCoordinatesView(modifier = Modifier.wrapContentWidth(), location = location)
            LocationAddButtonView(modifier = Modifier, location = location, onClickEvent = {})
        }
    }
}

@Composable
fun LocationNameView(
    modifier: Modifier,
    location: Location,
) {
    Box(modifier = modifier
        .padding(5.dp)
        .background(shape = RoundedCornerShape(5.dp), color = Color.LightGray)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = location.name, fontSize = 20.sp, color = Color.Black)
            Text(text = location.country, fontSize = 20.sp, color = Color.Black)
        }
    }
}

@Composable
fun LocationCoordinatesView(
    modifier: Modifier,
    location: Location,
) {
    Box(modifier = modifier
        .padding(5.dp)
        .background(shape = RoundedCornerShape(5.dp), color = Color.LightGray)) {
        Column(modifier = Modifier.padding(5.dp)) {
            Text(text = "latitude: ${location.latitude}", fontSize = 20.sp, color = Color.Black)
            Text(text = "longitude: ${location.longitude}", fontSize = 20.sp, color = Color.Black)
        }
    }
}

@Composable
fun LocationAddButtonView(
    modifier: Modifier,
    location: Location,
    onClickEvent: (Location) -> Unit
) {
    Box(modifier = modifier
        .padding(5.dp)
        .background(shape = CircleShape, color = Color.Cyan)) {
        IconButton(onClick = { onClickEvent(location) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }
}

@Composable
fun WeatherTemperatureView(
    modifier: Modifier,
    temperature: CurrentWeather.Companion.Metrics
) {
    Box(modifier = modifier
        .padding(5.dp)
        .background(shape = RoundedCornerShape(5.dp), color = Color.LightGray)
    ) {
        Column {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWeatherView() {
//    LocationInfoView(location = Location("Example City 1", mapOf(), 0.0, 0.0, "EX1", null))
    WeatherTemperatureView(
        modifier = Modifier,
        temperature = CurrentWeather.Companion.Metrics(
            5.0,
            5.0,
            5.0,
            6.0,
            123,
            123,
            567,
            567
        )
    )
}