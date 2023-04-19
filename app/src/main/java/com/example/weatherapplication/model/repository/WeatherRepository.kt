package com.example.weatherapplication.model.repository

import com.example.weatherapplication.model.data.CurrentWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRepository {
    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") id: String
    ): Call<CurrentWeather>
}