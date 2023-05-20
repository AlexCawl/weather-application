package com.example.weatherapplication.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.dao.Database
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.data.Position
import com.example.weatherapplication.model.service.ForecastService
import com.example.weatherapplication.model.service.LocationService

class WeatherViewModel : ViewModel() {
    private val forecastService: ForecastService = ForecastService()
    private val locationService: LocationService = LocationService()

    val locations: SnapshotStateMap<String, Location> = Database.loadData().let {
        mutableStateMapOf<String, Location>().apply { putAll(it) }
    }

    fun updateHints(hints: SnapshotStateList<Position>, query: MutableState<String>) {
        locationService.updateLocations(hints, query.value)
    }

    fun addLocation(position: Position) {
        TODO()
    }

    fun refreshData() {
        TODO()
    }

    fun refreshData(id: String) {
        TODO()
    }

//    private fun updateCurrentForecast(location: Weather) {
//        location.updateCurrentWeather { forecast, latitude, longitude ->
//            forecastService.updateCurrentForecast(forecast, latitude, longitude)
//        }
//    }
}