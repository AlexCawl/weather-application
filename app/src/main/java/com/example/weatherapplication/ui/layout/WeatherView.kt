package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.Forecast
import com.example.weatherapplication.model.Location
import com.example.weatherapplication.model.Weather
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun WeatherView(
    weather: Weather,
    getCity: (Location) -> String,
    getTemperature: (Forecast) -> String,
    getWeatherType: (Forecast) -> String,
    getWindSpeed: (Forecast) -> String,
    getHumidity: (Forecast) -> String,
    getCloudiness: (Forecast) -> String,
    getDatetime: (Forecast) -> Pair<String, String>,
    getPrecipitation: (Forecast) -> String,
    getIconID: (Forecast) -> Int
) {
    val place = remember { weather.locationState }
    val currentForecast = remember { weather.forecastCurrentState }
    val futureForecast = remember { weather.forecastAheadState }

    Column(
        modifier = Modifier.padding(15.dp)
    ) {
        PlaceInfoView(
            location = place.value, cityRepresentationFunction = getCity
        )
        TemperatureInfoView(
            forecast = currentForecast.value,
            temperatureRepresentationFunction = getTemperature,
            weatherTypeRepresentationFunction = getWeatherType,
            iconRepresentationFunction = getIconID
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
                .fillMaxWidth()
        )
        WeatherInfoView(
            forecast = currentForecast.value,
            weatherSpeedRepresentationFunction = getWindSpeed,
            humidityRepresentationFunction = getHumidity,
            cloudinessRepresentationFunction = getCloudiness
        )
        Spacer(
            modifier = Modifier
                .height(15.dp)
                .fillMaxWidth()
        )
        ForecastInfoView(
            content = futureForecast,
            getDatetime = getDatetime,
            getTemperature = getTemperature,
            getPrecipitation = getPrecipitation,
            getIconID = getIconID
        )
    }
}
