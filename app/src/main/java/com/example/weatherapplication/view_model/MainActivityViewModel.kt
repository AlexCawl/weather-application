package com.example.weatherapplication.view_model

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.Place
import com.example.weatherapplication.model.data.LocationInfo
import com.example.weatherapplication.model.service.PlaceService
import com.example.weatherapplication.model.service.WeatherService

class MainActivityViewModel : ViewModel() {
    private val weatherService: WeatherService = WeatherService()
    private val placeService: PlaceService = PlaceService()
    private val locations: MutableMap<Place, LocationInfo>  = mutableMapOf()

       private fun updateCurrentForecast(location: LocationInfo) {
           location.updateCurrentForecast { weatherService.updateCurrentForecast(it, location.place.latitude, location.place.longitude)  }

    }
}