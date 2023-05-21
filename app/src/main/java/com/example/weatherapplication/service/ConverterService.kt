package com.example.weatherapplication.service

import com.example.weatherapplication.R
import com.example.weatherapplication.model.Forecast
import com.example.weatherapplication.model.Location
import java.time.LocalDateTime

// TODO() parameters
class ConverterService {
    private val time: LocalDateTime = LocalDateTime.now()
    fun getTime(): String {
        return "${
            time.dayOfMonth
        } ${
            time.month.toString().lowercase().replaceFirstChar(Char::uppercaseChar)
        } ${
            time.year
        }, ${
            time.dayOfWeek.toString().lowercase().replaceFirstChar(Char::uppercaseChar)
        }"
    }

    fun getTemperature(forecast: Forecast): String {
        return "${forecast.temperature.toInt()}°"
    }

    fun getTime(forecast: Forecast): Pair<String, String> {
        val datetime = forecast.time
        return Pair(
            "${datetime.dayOfMonth} ${
                datetime.month.toString().lowercase().replaceFirstChar(Char::uppercaseChar)
            }", "${datetime.hour}:${if (datetime.minute == 0) "00" else datetime.minute}"
        )
    }

    fun getCityName(location: Location): String {
        return "${location.name} ${location.countryCode}"
    }

    fun getWeatherType(forecast: Forecast): String {
        return forecast.weatherDescription.split("\\W+".toRegex()).joinToString(" ") {
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
        return "${(forecast.precipitationProbability * 100.0).toInt()} %"
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