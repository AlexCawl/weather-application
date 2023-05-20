package com.example.weatherapplication.vm

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.Position
import com.example.weatherapplication.model.service.LocationService

class LocationViewModel : ViewModel() {
    private val locationService: LocationService = LocationService()

    val hints: SnapshotStateList<Position> = mutableStateListOf()
    val query: MutableState<String> = mutableStateOf("")

    fun updateHints() {
        locationService.updateLocations(hints, query.value)
    }
}