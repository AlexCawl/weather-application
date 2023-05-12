package com.example.weatherapplication.view_model

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.dao.Database
import com.example.weatherapplication.model.data.Place
import com.example.weatherapplication.model.data.Weather
import com.example.weatherapplication.model.service.PlaceService
import com.example.weatherapplication.model.service.ForecastService

class WeatherViewModel : ViewModel() {
    private val forecastService: ForecastService = ForecastService()
    private val placeService: PlaceService = PlaceService()
    val locations: MutableMap<String, Weather> = Database.loadData().toMutableMap()

   private fun updateCurrentForecast(location: Weather) {
       location.updateCurrentWeather { forecast, latitude, longitude ->
           forecastService.updateCurrentForecast(forecast, latitude, longitude)
       }
   }
}