package com.example.weatherapplication.retrofit.repository

import com.example.weatherapplication.retrofit.pojo.SingleForecastPOJO
import com.example.weatherapplication.retrofit.pojo.MultiForecastPOJO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherRepository {
    @GET("data/2.5/weather")
    fun getCurrentForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") id: String,
        @Query("units") units: String = "metric",
        @Query("lang") language: String = "en"
    ): Call<SingleForecastPOJO>

    @GET("data/2.5/forecast")
    fun getHourlyForecast(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query("appid") id: String,
        @Query("units") units: String = "metric",
        @Query("cnt") count: Int = 40,
        @Query("lang") language: String = "en"
    ): Call<MultiForecastPOJO>
}