package com.example.weatherapplication.view_model

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.dao.Database
import com.example.weatherapplication.model.data.Weather
import com.example.weatherapplication.model.service.ForecastService
import com.example.weatherapplication.model.service.LocationService

class WeatherViewModel : ViewModel() {
    private val forecastService: ForecastService = ForecastService()
    private val locationService: LocationService = LocationService()

    val locations: SnapshotStateMap<String, Weather> = Database.loadData().let {
        mutableStateMapOf<String, Weather>().apply { putAll(it) }
    }

//    private fun updateCurrentForecast(location: Weather) {
//        location.updateCurrentWeather { forecast, latitude, longitude ->
//            forecastService.updateCurrentForecast(forecast, latitude, longitude)
//        }
//    }
}