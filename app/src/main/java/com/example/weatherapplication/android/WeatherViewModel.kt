package com.example.weatherapplication.android

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.Location
import com.example.weatherapplication.model.Weather
import com.example.weatherapplication.service.ForecastService
import com.example.weatherapplication.service.LocationService

class WeatherViewModel : ViewModel() {
    private val forecastService: ForecastService = ForecastService()
    private val locationService: LocationService = LocationService()
    val locations: SnapshotStateMap<String, Weather> = mutableStateMapOf()

    fun updateHints(hints: SnapshotStateList<Location>, query: MutableState<String>) {
        locationService.updateLocations(hints, query.value)
    }

    fun addWeather(location: Location) {
        val weather = Weather(location)
        updateData(weather)
        locations[location.hashCode().toString()] = weather
    }

    fun removeLocation(identifier: String) {
        locations.remove(identifier)
    }

    fun refreshData() {
        TODO()
    }

    fun refreshData(identifier: String) {
        when (val location = locations[identifier]) {
            null -> {}
            else -> {
                updateData(location)
            }
        }
    }

    @Throws(NullPointerException::class)
    private fun updateData(weather: Weather) {
        val location: Location = weather.locationState.value
        forecastService.updateCurrentForecast(
            weather.forecastCurrentState,
            location.latitude,
            location.longitude
        )
        forecastService.updateFutureForecast(
            weather.forecastAheadState,
            location.latitude,
            location.longitude
        )
    }
}