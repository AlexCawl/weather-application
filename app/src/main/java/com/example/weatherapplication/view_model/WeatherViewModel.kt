package com.example.weatherapplication.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.service.WeatherService

class WeatherViewModel : ViewModel() {
    private val weatherService: WeatherService = WeatherService()

    val forecastCurrent: MutableState<Forecast?> = mutableStateOf(null)
    val forecastHourly: SnapshotStateList<Forecast> = mutableStateListOf()
    private val currentLocation: MutableState<Location?> = mutableStateOf(null)

    fun updateCurrentWeather(location: Location) {
        currentLocation.value = location
        weatherService.updateCurrentForecast(forecastCurrent, location.latitude, location.longitude)
    }
}