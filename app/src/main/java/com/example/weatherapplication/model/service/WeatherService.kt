package com.example.weatherapplication.model.service

import android.util.Log
import androidx.compose.runtime.MutableState
import com.example.weatherapplication.model.data.CurrentWeather
import com.example.weatherapplication.model.repository.RepositoryFactory
import com.example.weatherapplication.model.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherService {
    private val weatherRepository: WeatherRepository = RepositoryFactory
        .getInstance()
        .create(WeatherRepository::class.java)

    fun updateCurrentWeather(
        currentWeather: MutableState<CurrentWeather?>,
        latitude: Double,
        longitude: Double
    ) {
        println("UPDATING $latitude $longitude")
        val call: Call<CurrentWeather> =
            weatherRepository.getCurrentWeather(latitude, longitude, IdentifierService.id)

        call.enqueue(object : Callback<CurrentWeather> {
            override fun onResponse(
                call: Call<CurrentWeather>,
                response: Response<CurrentWeather>
            ) {
                Log.println(
                    Log.INFO,
                    this::class.java.toString(),
                    "${response.code()} ${response.message()} ${response.body()}"
                )
                if (response.body() != null) {
                    currentWeather.value = response.body()
                }
            }

            override fun onFailure(call: Call<CurrentWeather>, t: Throwable) {
                Log.println(
                    Log.ERROR,
                    this::class.java.toString(),
                    t.stackTraceToString()
                )
                call.cancel()
            }
        })
    }
}