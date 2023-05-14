package com.example.weatherapplication.model.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList


class Weather(
    location: Location,
    forecastCurrent: Forecast,
    forecastFuture: List<Forecast>
) {
    val location: MutableState<Location> = mutableStateOf(location)
    val currentWeather: MutableState<Forecast> = mutableStateOf(forecastCurrent)
    val futureWeather: SnapshotStateList<Forecast> = mutableStateListOf<Forecast>().let {
        it.addAll(forecastFuture)
        it
    }

    fun updateCurrentWeather(updateFunction: (MutableState<Forecast>, Double, Double) -> Unit) {
        updateFunction(currentWeather, location.value.latitude, location.value.longitude)
    }

    fun updateFutureWeather(updateFunction: (SnapshotStateList<Forecast>, Double, Double) -> Unit) {
        updateFunction(futureWeather, location.value.latitude, location.value.longitude)
    }
}