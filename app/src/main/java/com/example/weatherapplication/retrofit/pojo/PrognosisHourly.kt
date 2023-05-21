package com.example.weatherapplication.retrofit.pojo

import com.google.gson.annotations.SerializedName

data class PrognosisHourly(
    @SerializedName("cod") val code: String,
    @SerializedName("message") val message: Int,
    @SerializedName("cnt") val count: Int,
    @SerializedName("list") val content: List<PrognosisHourlyItem>,
    @SerializedName("city") val city: City,
) {
    companion object {
        data class City(
            @SerializedName("id") val identifier: Int,
            @SerializedName("name") val name: String,
            @SerializedName("coord") val coordinates: Coordinates,
            @SerializedName("country") val country: String,
            @SerializedName("population") val population: Int,
            @SerializedName("timezone") val timezone: Long,
            @SerializedName("sunrise") val sunrise: Long,
            @SerializedName("sunset") val sunset: Long,
        )

        data class Coordinates(
            @SerializedName("lon") val longitude: Double,
            @SerializedName("lat") val latitude: Double
        )
    }
}