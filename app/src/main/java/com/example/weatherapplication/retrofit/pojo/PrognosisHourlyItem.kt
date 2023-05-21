package com.example.weatherapplication.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class PrognosisHourlyItem(
    @SerializedName("dt") val datetime: Long,
    @SerializedName("main") val metrics: Metrics,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("clouds") val cloudiness: Cloudiness,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("rain") val rain: Rain?,
    @SerializedName("snow") val snow: Snow?,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("pop") val precipitationProbability: Double,
    @SerializedName("sys") val system: System,
    @SerializedName("dt_text") val datetimeAsText: String
) {
    companion object {
        data class Metrics(
            @SerializedName("temp") val temperatureReal: Double,
            @SerializedName("feels_like") val temperatureFeel: Double,
            @SerializedName("temp_min") val temperatureMinimum: Double,
            @SerializedName("temp_max") val temperatureMaximum: Double,
            @SerializedName("pressure") val pressure: Int,
            @SerializedName("sea_level") val seaLevel: Int,
            @SerializedName("grnd_level") val groundLevel: Int,
            @SerializedName("humidity") val humidity: Int,
            @SerializedName("temp_kf") val temperatureCoefficient: Double
        )

        data class Weather(
            @SerializedName("id") val identifier: Int,
            @SerializedName("main") val type: String,
            @SerializedName("description") val description: String,
            @SerializedName("icon") val icon: String
        )

        data class Wind(
            @SerializedName("speed") val speed: Double,
            @SerializedName("deg") val direction: Int,
            @SerializedName("gust") val gust: Double,
        )

        data class Cloudiness(
            @SerializedName("all") val cloudiness: Int
        )

        data class Rain(
            @SerializedName("1h") val oneHour: Double,
        )

        data class Snow(
            @SerializedName("1h") val oneHour: Double,
        )

        data class System(
            @SerializedName("pod") val partOfDay: String,
        )
    }
}