package com.example.weatherapplication.model.service

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.weatherapplication.model.data.Prognosis
import com.example.weatherapplication.model.data.PrognosisHourly
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
        forecast: MutableState<Forecast>,
        latitude: Double,
        longitude: Double
    ) {
        val call: Call<Prognosis> =
            weatherRepository.getCurrentForecast(latitude, longitude, IdentifierService.id)
        val mappingFunction: (Response<Prognosis>, MutableState<Forecast>) -> Unit =
            { response, data ->
                if (response.body() != null) {
                    val body: Prognosis = response.body()
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
        val call: Call<PrognosisHourly> = weatherRepository.getHourlyForecast(latitude, longitude, IdentifierService.id)
        val mappingFunction: (Response<PrognosisHourly>, SnapshotStateList<Forecast>) -> Unit =
            { response, data ->
                if (response.body() != null) {
                    val body: PrognosisHourly = response.body()
                    val cityName: String = body.city.name
                    val cityLatitude: Double = body.city.coordinates.latitude
                    val cityLongitude: Double = body.city.coordinates.longitude

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