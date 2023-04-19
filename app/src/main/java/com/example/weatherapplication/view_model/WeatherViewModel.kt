package com.example.weatherapplication.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.CurrentWeather
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.service.WeatherService

class WeatherViewModel : ViewModel() {
    private val weatherService: WeatherService = WeatherService()

    val currentWeather: MutableState<CurrentWeather?> = mutableStateOf(null)
    val currentLocation: MutableState<Location?> = mutableStateOf(null)

    fun updateCurrentWeather(location: Location) {
        currentLocation.value = location
        weatherService.updateCurrentWeather(currentWeather, location.latitude, location.longitude)
    }
}