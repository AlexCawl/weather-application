package com.example.weatherapplication.model.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList


class Location(
    position: Position,
    forecastCurrent: Forecast,
    forecastFuture: List<Forecast>
) {
    val position: MutableState<Position> = mutableStateOf(position)
    val currentWeather: MutableState<Forecast> = mutableStateOf(forecastCurrent)
    val forecasts: SnapshotStateList<Forecast> = mutableStateListOf<Forecast>().let {
        it.addAll(forecastFuture)
        it
    }

    fun updateCurrentWeather(updateFunction: (MutableState<Forecast>, Double, Double) -> Unit) {
        updateFunction(currentWeather, position.value.latitude, position.value.longitude)
    }

    fun updateFutureWeather(updateFunction: (SnapshotStateList<Forecast>, Double, Double) -> Unit) {
        updateFunction(forecasts, position.value.latitude, position.value.longitude)
    }
}