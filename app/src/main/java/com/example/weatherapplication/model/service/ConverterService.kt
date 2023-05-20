package com.example.weatherapplication.model.service

import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.data.Position

// TODO() parameters
class ConverterService {
    fun getTemperature(forecast: Forecast): String {
        return "${forecast.temperature.toInt()}°"
    }

    fun getPairTemperature(forecast: Forecast): Pair<String, String> {
        return Pair(
            "${forecast.temperatureMinimum.toInt()}°",
            "${forecast.temperatureMaximum.toInt()}°",
        )
    }

    fun getTime(forecast: Forecast, withDays: Boolean = false): String {
        val datetime = forecast.datetime
        return when (withDays) {
            true -> "${datetime.monthValue}.${datetime.dayOfMonth} ${datetime.hour}:${datetime.second}"
            false -> "${datetime.hour}:${datetime.second}"
        }
    }

    fun getCityName(position: Position): String {
        return "${position.name} ${position.country}"
    }

    fun getWeatherType(forecast: Forecast): String {
        // TODO()
        return "Cloudy"
    }

    fun getWeatherSpeed(forecast: Forecast): String {
        return "${forecast.windSpeed.toInt()} m/s"
    }

    fun getHumidity(forecast: Forecast): String {
        return "${forecast.humidity} %"
    }

    fun getPrecipitation(forecast: Forecast): String {
        return "${forecast.precipitationProbability} %"
    }
}