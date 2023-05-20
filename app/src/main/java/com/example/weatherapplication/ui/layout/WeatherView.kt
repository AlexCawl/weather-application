package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.data.Position
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun WeatherView(
    screenIdentifier: String,
    location: Location,
    cityRepresentationFunction: (Position) -> String,
    temperatureRepresentationFunction: (Forecast) -> String,
    weatherTypeRepresentationFunction: (Forecast) -> String,
    weatherSpeedRepresentationFunction: (Forecast) -> String,
    humidityRepresentationFunction: (Forecast) -> String,
    precipitationRepresentationFunction: (Forecast) -> String,
    dateTimeRepresentationFunction: (Forecast) -> String,
    minMaxTemperatureRepresentationFunction: (Forecast) -> Pair<String, String>
) {
    val place = remember { location.position }
    val currentForecast = remember { location.currentWeather }
    val futureForecast = remember { location.forecasts }

    Box(
        modifier = Modifier.padding(15.dp)
    ) {
        Column {
            PlaceInfoView(
                position = place.value, cityRepresentationFunction = cityRepresentationFunction
            )
            TemperatureInfoView(
                forecast = currentForecast.value,
                temperatureRepresentationFunction = temperatureRepresentationFunction,
                weatherTypeRepresentationFunction = weatherTypeRepresentationFunction
            )
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
            )
            WeatherInfoView(
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
            ForecastInfoView(
                content = futureForecast,
                dateTimeRepresentationFunction = dateTimeRepresentationFunction,
                minMaxTemperatureRepresentationFunction = minMaxTemperatureRepresentationFunction
            )
        }
    }
}
