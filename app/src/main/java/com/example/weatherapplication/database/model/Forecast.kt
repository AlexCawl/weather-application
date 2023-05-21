package com.example.weatherapplication.database.model

import java.time.LocalDateTime

/**
 *
 * */
data class Forecast(
    val cityName: String,
    val latitude: Double,
    val longitude: Double,
    val temperature: Double,
    val temperatureMinimum: Double,
    val temperatureMaximum: Double,
    val humidity: Int,
    val windSpeed: Double,
    val cloudiness: Int,
    val datetime: LocalDateTime,
    val weatherDescription: String,
    val weatherType: String,
    val precipitationProbability: Double? = null
)