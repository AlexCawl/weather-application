package com.example.weatherapplication.model.service

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.weatherapplication.model.data.ForecastCurrent
import com.example.weatherapplication.model.data.ForecastHourly
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.repository.RepositoryFactory
import com.example.weatherapplication.model.repository.WeatherCallback
import com.example.weatherapplication.model.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Response
import java.time.LocalDateTime
import java.time.ZoneOffset

class ForecastService {
    private val weatherRepository: WeatherRepository = RepositoryFactory
        .getInstance()
        .create(WeatherRepository::class.java)

    fun updateCurrentForecast(
        forecast: MutableState<Forecast?>,
        latitude: Double,
        longitude: Double
    ) {
        val call: Call<ForecastCurrent> =
            weatherRepository.getCurrentForecast(latitude, longitude, IdentifierService.id)
        val mappingFunction: (Response<ForecastCurrent>, MutableState<Forecast?>) -> Unit =
            { response, data ->
                if (response.body() != null) {
                    val body: ForecastCurrent = response.body()
                    data.value = Forecast(
                        body.cityName,
                        body.coordinates.latitude,
                        body.coordinates.longitude,
                        body.metrics.temperatureReal,
                        body.metrics.temperatureMinimum,
                        body.metrics.temperatureMaximum,
                        body.metrics.humidity,
                        body.wind.speed,
                        body.clouds.cloudiness,
                        LocalDateTime.ofEpochSecond(body.datetime, 0, ZoneOffset.UTC)
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
        val call: Call<ForecastHourly> = weatherRepository.getHourlyForecast(latitude, longitude, IdentifierService.id)
        val mappingFunction: (Response<ForecastHourly>, SnapshotStateList<Forecast>) -> Unit =
            { response, data ->
                if (response.body() != null) {
                    val body: ForecastHourly = response.body()
                    val cityName: String = body.city.name
                    val cityLatitude: Double = body.city.coordinates.latitude
                    val cityLongitude: Double = body.city.coordinates.longitude
                    val timezone: Long = body.city.timezone

                    data.clear()
                    data.addAll(
                        body.content.map {
                            Forecast(
                                cityName,
                                cityLatitude,
                                cityLongitude,
                                it.metrics.temperatureReal,
                                it.metrics.temperatureMinimum,
                                it.metrics.temperatureMaximum,
                                it.metrics.humidity,
                                it.wind.speed,
                                it.cloudiness.cloudiness,
                                LocalDateTime.ofEpochSecond(it.datetime, 0, ZoneOffset.UTC),
                                it.precipitationProbability
                            )
                        }
                    )
                }
            }
        call.enqueue(WeatherCallback(forecast, mappingFunction))
    }
}