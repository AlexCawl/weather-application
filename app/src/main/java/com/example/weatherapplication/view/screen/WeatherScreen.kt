package com.example.weatherapplication.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.dao.Database
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.data.Place
import com.example.weatherapplication.model.data.Weather
import com.example.weatherapplication.view.layout.ForecastInfo
import com.example.weatherapplication.view.layout.PlaceInfo
import com.example.weatherapplication.view.layout.TemperatureInfo
import com.example.weatherapplication.view.layout.WeatherInfo
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun WeatherScreen(
    screenIdentifier: String,
    weather: Weather,
    cityRepresentationFunction: (Place) -> String,
    temperatureRepresentationFunction: (Forecast) -> String,
    weatherTypeRepresentationFunction: (Forecast) -> String,
    weatherSpeedRepresentationFunction: (Forecast) -> String,
    humidityRepresentationFunction: (Forecast) -> String,
    precipitationRepresentationFunction: (Forecast) -> String,
) {
    val place = remember { weather.place }
    val currentForecast = remember { weather.currentWeather }
    val futureForecast = remember { weather.futureWeather }

    Box(
        modifier = Modifier
            .padding(15.dp)
    ) {
        Column {
            PlaceInfo(
                place = place.value,
                cityRepresentationFunction = cityRepresentationFunction
            )
            TemperatureInfo(
                forecast = currentForecast.value,
                temperatureRepresentationFunction = temperatureRepresentationFunction,
                weatherTypeRepresentationFunction = weatherTypeRepresentationFunction
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
            )
            WeatherInfo(
                forecast = currentForecast.value,
                weatherSpeedRepresentationFunction = weatherSpeedRepresentationFunction,
                humidityRepresentationFunction = humidityRepresentationFunction,
                precipitationRepresentationFunction = precipitationRepresentationFunction
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
            )
            ForecastInfo(futureForecast)
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
@Preview
fun WeatherScreenPreview() {
    WeatherApplicationTheme(
        darkTheme = true
    ) {
        WeatherScreen(
            screenIdentifier = "Moscow",
            weather = Database.loadData()["Moscow"]!!,
            cityRepresentationFunction = { "" },
            temperatureRepresentationFunction = { "" },
            weatherTypeRepresentationFunction = { "" },
            weatherSpeedRepresentationFunction = { "" },
            humidityRepresentationFunction = { "" },
            precipitationRepresentationFunction = { "" }
        )
    }
}