package com.example.weatherapplication.model

import java.time.LocalDateTime

/**
 * Data class used to represent important weather data at a specific time.
 * */
data class Forecast(
    val time: LocalDateTime,
    val temperature: Double,
    val pressure: Int,
    val humidity: Int,
    val weatherType: String, // ADD ENUM CLASS TODO()
    val weatherDescription: String,
    val windSpeed: Double,
    val windDirection: Int,
    val cloudiness: Int,
    val rainfallPerHour: Double,
    val snowfallPerHour: Double,
    val precipitationProbability: Double
) {
    companion object {
        fun create(): Forecast = Forecast(
            LocalDateTime.now(),
            0.0,
            0,
            0,
            "",
            "",
            0.0,
            0,
            0,
            0.0,
            0.0,
            0.0
        )
    }
}