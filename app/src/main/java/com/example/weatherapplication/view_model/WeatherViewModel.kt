package com.example.weatherapplication.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.service.WeatherService
import java.time.LocalDateTime

class WeatherViewModel : ViewModel() {
    private val weatherService: WeatherService = WeatherService()

    val forecastCurrent: MutableState<Forecast?> = mutableStateOf(null)
    val forecastHourly: SnapshotStateList<Forecast> = mutableStateListOf(
        Forecast(
        "Moscow",
        1.0,
        1.0,
        5.0,
        -1.0,
        6.0,
        55,
        10.0,
        67, LocalDateTime.now()
        ),
        Forecast(
        "Moscow",
        1.0,
        1.0,
        5.0,
        -5.0,
        7.0,
        55,
        10.0,
        67, LocalDateTime.now()
        ),
        Forecast(
        "Moscow",
        1.0,
        1.0,
        5.0,
        -3.0,
        2.0,
        55,
        10.0,
        67, LocalDateTime.now()
        )
    )
    private val currentLocation: MutableState<Location?> = mutableStateOf(null)

    fun updateCurrentWeather(location: Location) {
        currentLocation.value = location
        weatherService.updateCurrentForecast(forecastCurrent, location.latitude, location.longitude)
    }
}