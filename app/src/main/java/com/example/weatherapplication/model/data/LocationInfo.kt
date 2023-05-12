package com.example.weatherapplication.model.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList

class LocationInfo(
    val place: Place,
    val forecastCurrent: MutableState<Forecast?>,
    val forecastFuture: SnapshotStateList<Forecast>
) {
    fun updateCurrentForecast(updateFunction: (MutableState<Forecast?>, Double, Double) -> Unit) {
        updateFunction(forecastCurrent, forecastCurrent.value!!.latitude, forecastCurrent.value!!.longitude)
    }

    fun updateFutureForecast(updateFunction: (SnapshotStateList<Forecast>) -> Unit) {
        updateFunction(forecastFuture)
    }
}