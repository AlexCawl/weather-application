package com.example.weatherapplication.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class SingleForecastPOJO(
    @SerializedName("coord") val coordinates: Coordinates,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("base") val base: String,
    @SerializedName("main") val metrics: Metrics,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("wind") val wind: Wind,
    @SerializedName("clouds") val clouds: Cloudiness,
    @SerializedName("rain") val rain: Rain?,
    @SerializedName("snow") val snow: Snow?,
    @SerializedName("dt") val datetime: Long,
    @SerializedName("sys") val system: System,
    @SerializedName("timezone") val timezone: Long,
    @SerializedName("id") val cityID: String,
    @SerializedName("name") val cityName: String,
    @SerializedName("cod") val code: String,
) {
    companion object {
        data class Coordinates(
            @SerializedName("lon") val longitude: Double,
            @SerializedName("lat") val latitude: Double
        )

        data class Weather(
            @SerializedName("id") val identifier: Int,
            @SerializedName("main") val type: String,
            @SerializedName("description") val description: String,
            @SerializedName("icon") val icon: String
        )

        data class Metrics(
            @SerializedName("temp") val temperatureReal: Double,
            @SerializedName("feels_like") val temperatureFeel: Double,
            @SerializedName("temp_min") val temperatureMinimum: Double,
            @SerializedName("temp_max") val temperatureMaximum: Double,
            @SerializedName("pressure") val pressure: Int,
            @SerializedName("humidity") val humidity: Int,
            @SerializedName("sea_level") val seaLevel: Int,
            @SerializedName("grnd_level") val groundLevel: Int,
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
            @SerializedName("1h") val oneHour: Double, @SerializedName("3h") val threeHour: Double
        )

        data class Snow(
            @SerializedName("1h") val oneHour: Double, @SerializedName("3h") val threeHour: Double
        )

        data class System(
            @SerializedName("type") val type: Int,
            @SerializedName("id") val identifier: Int,
            @SerializedName("message") val message: String?,
            @SerializedName("country") val country: String,
            @SerializedName("sunrise") val sunrise: Long,
            @SerializedName("sunset") val sunset: Long,
        )
    }
}