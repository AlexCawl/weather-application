package com.example.weatherapplication.model.service

import com.example.weatherapplication.R
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
        return forecast.weatherDescription
            .split("\\W+".toRegex())
            .joinToString(" ") {
                it.replaceFirstChar(Char::uppercaseChar)
            }
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

    fun getCloudiness(forecast: Forecast): String {
        return "${forecast.cloudiness} %"
    }

    fun getIconID(forecast: Forecast): Int {
        return when (forecast.weatherType) {
            "Thunderstorm" -> R.drawable.icon_thunder
            "Drizzle", "Rain" -> R.drawable.icon_rainy
            "Snow" -> R.drawable.icon_snowy
            "Clear" -> R.drawable.icon_clear
            else -> R.drawable.icon_cloudy
        }
    }
}