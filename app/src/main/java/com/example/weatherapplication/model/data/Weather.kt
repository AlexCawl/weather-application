package com.example.weatherapplication.model.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList


class Weather(
    val place: Place,
    forecastCurrent: Forecast?,
    forecastFuture: List<Forecast>
) {
    val currentWeather: MutableState<Forecast?> = mutableStateOf(forecastCurrent)
    val futureWeather: SnapshotStateList<Forecast> = mutableStateListOf<Forecast>().let {
        it.addAll(forecastFuture)
        it
    }

    fun updateCurrentWeather(updateFunction: (MutableState<Forecast?>, Double, Double) -> Unit) {
        updateFunction(currentWeather, place.latitude, place.longitude)
    }

    fun updateFutureWeather(updateFunction: (SnapshotStateList<Forecast>, Double, Double) -> Unit) {
        updateFunction(futureWeather, place.latitude, place.longitude)
    }
}