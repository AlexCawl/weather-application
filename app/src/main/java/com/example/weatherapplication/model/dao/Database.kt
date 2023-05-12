package com.example.weatherapplication.model.dao

import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.data.Place
import com.example.weatherapplication.model.data.Weather
import java.time.LocalDateTime

/**
 * Mocked Database
 * */
class Database {
    companion object {
        private val place: Place = Place("Moscow", mapOf(), 87.3, -45.7, "RU", null)
        private val forecast: Forecast = Forecast("Moscow", 87.3, -45.7, 18.7, 15.6, 20.3, 56, 10.5, 86, LocalDateTime.now(), null)
        private val forecasts: List<Forecast> = listOf(forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast)

        fun loadData(): Map<String, Weather> {
            return mapOf(
                Pair("Moscow", Weather(place, forecast, forecasts)),
                Pair("Moscow", Weather(place, forecast, forecasts)),
                Pair("Moscow", Weather(place, forecast, forecasts)),
                Pair("Moscow", Weather(place, forecast, forecasts)),
                Pair("Moscow", Weather(place, forecast, forecasts)),
            )
        }
    }
}