package com.example.weatherapplication.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList

class Weather(
    location: Location
) {
    val locationState: MutableState<Location> = mutableStateOf(location)
    val forecastCurrentState: MutableState<Forecast> = mutableStateOf(Forecast.create())
    val forecastAheadState: SnapshotStateList<Forecast> = mutableStateListOf()
}