package com.example.weatherapplication.service

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.weatherapplication.model.Forecast
import com.example.weatherapplication.retrofit.WeatherCallback
import com.example.weatherapplication.retrofit.pojo.MultiForecastPOJO
import com.example.weatherapplication.retrofit.pojo.SingleForecastPOJO
import com.example.weatherapplication.retrofit.repository.RepositoryFactory
import com.example.weatherapplication.retrofit.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.ZoneOffset

// Refactor this TODO
class ForecastService {
    private val weatherRepository: WeatherRepository = RepositoryFactory
        .getInstance()
        .create(WeatherRepository::class.java)

    fun updateCurrentForecast(
        forecast: MutableState<Forecast>,
        latitude: Double,
        longitude: Double
    ) {
        val call: Call<SingleForecastPOJO> = weatherRepository.getCurrentForecast(
            latitude, longitude,
            IdentifierService.id
        )
        val mappingFunction: (Response<SingleForecastPOJO>, MutableState<Forecast>) -> Unit =
            { response, data ->
                if (response.body() != null) {
                    val body: SingleForecastPOJO = response.body()
                    data.value = Forecast(
                        LocalDateTime.ofEpochSecond(body.datetime, 0, ZoneOffset.UTC),
                        body.metrics.temperatureReal,
                        body.metrics.pressure,
                        body.metrics.humidity,
                        body.weather[0].type,
                        body.weather[0].description,
                        body.wind.speed,
                        body.wind.direction,
                        body.clouds.cloudiness,
                        body.rain?.oneHour ?: 0.0,
                        body.snow?.oneHour ?: 0.0,
                        0.0
                    )
                }
            }
        call.enqueue(WeatherCallback(forecast, mappingFunction))
    }

    fun updateFutureForecast(
        forecast: SnapshotStateList<Forecast>,
        latitude: Double,
        longitude: Double
    ) {
        val call: Call<MultiForecastPOJO> = weatherRepository.getHourlyForecast(
            latitude, longitude,
            IdentifierService.id
        )
        val mappingFunction: (Response<MultiForecastPOJO>, SnapshotStateList<Forecast>) -> Unit =
            { response, data ->
                if (response.body() != null) {
                    val body: MultiForecastPOJO = response.body()
                    data.clear()
                    data.addAll(
                        body.content.map {
                            Forecast(
                                LocalDateTime.ofEpochSecond(it.datetime, 0, ZoneOffset.UTC),
                                it.metrics.temperatureReal,
                                it.metrics.pressure,
                                it.metrics.humidity,
                                it.weather[0].type,
                                it.weather[0].description,
                                it.wind.speed,
                                it.wind.direction,
                                it.cloudiness.cloudiness,
                                it.rain?.oneHour ?: 0.0,
                                it.snow?.oneHour ?: 0.0,
                                it.precipitationProbability
                            )
                        }
                    )
                }
            }
        call.enqueue(WeatherCallback(forecast, mappingFunction))
    }
}