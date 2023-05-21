package com.example.weatherapplication.android

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.database.model.Location
import com.example.weatherapplication.retrofit.pojo.Position
import com.example.weatherapplication.service.ForecastService
import com.example.weatherapplication.service.LocationService

class WeatherViewModel : ViewModel() {
    private val forecastService: ForecastService = ForecastService()
    private val locationService: LocationService = LocationService()
    val locations: SnapshotStateMap<String, Location> = mutableStateMapOf()

    fun updateHints(hints: SnapshotStateList<Position>, query: MutableState<String>) {
        locationService.updateLocations(hints, query.value)
    }

    fun addLocation(position: Position) {
        val location = Location(mutableStateOf(position))
        updateData(location)
        locations[location.hashCode().toString()] = location
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
    private fun updateData(location: Location) {
        val position: Position = location.position.value
        forecastService.updateCurrentForecast(
            location.currentWeather,
            position.latitude,
            position.longitude
        )
        forecastService.updateFutureForecast(
            location.forecasts,
            position.latitude,
            position.longitude
        )
    }
}