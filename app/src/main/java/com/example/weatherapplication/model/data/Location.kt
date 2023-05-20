package com.example.weatherapplication.model.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList


data class Location(
    val position: MutableState<Position>,
    val currentWeather: MutableState<Forecast?> = mutableStateOf(null),
    val forecasts: SnapshotStateList<Forecast> = mutableStateListOf()
)