package com.example.weatherapplication.model.dao

import android.util.Log
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.data.Position
import com.example.weatherapplication.model.data.Location
import java.time.LocalDateTime

/**
 * Mocked Database
 * */
class Database {
    /*companion object {
        private val position: Position = Position("Moscow", mapOf(), 87.3, -45.7, "RU", null)
        private val forecast: Forecast = Forecast("Moscow", 87.3, -45.7, 18.7, 15.6, 20.3, 56, 10.5, 86, LocalDateTime.now(), 56.0)
        private val forecasts: List<Forecast> = listOf(forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast, forecast)

        fun loadData(): Map<String, Location> {
            Log.println(Log.INFO, "MockedDatabase", "initialized")
            return mapOf(
                Pair("Moscow", Location(position, forecast, forecasts)),
                Pair("Berlin", Location(position, forecast, forecasts)),
                Pair("Paris", Location(position, forecast, forecasts)),
                Pair("Chelyabinsk", Location(position, forecast, forecasts)),
                Pair("Tokyo", Location(position, forecast, forecasts)),
            )
        }
    }*/
}