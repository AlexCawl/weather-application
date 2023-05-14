package com.example.weatherapplication.model.dao

import android.util.Log
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.data.Weather
import java.time.LocalDateTime

/**
 * Mocked Database
 * */
class Database {
    companion object {
        private val location: Location = Location("Moscow", mapOf(), 87.3, -45.7, "RU", null)
        private val forecast: Forecast = Forecast("Moscow", 87.3, -45.7, 18.7, 15.6, 20.3, 56, 10.5, 86, LocalDateTime.now(), null)
        private val forecasts: List<Forecast> = listOf(forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast)

        fun loadData(): Map<String, Weather> {
            Log.println(Log.INFO, "MockedDatabase", "initialized")
            return mapOf(
                Pair("Moscow", Weather(location, forecast, forecasts)),
                Pair("Berlin", Weather(location, forecast, forecasts)),
                Pair("Paris", Weather(location, forecast, forecasts)),
                Pair("Chelyabinsk", Weather(location, forecast, forecasts)),
                Pair("Tokyo", Weather(location, forecast, forecasts)),
            )
        }
    }
}