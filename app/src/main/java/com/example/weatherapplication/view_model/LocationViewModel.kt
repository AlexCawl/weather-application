package com.example.weatherapplication.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.service.LocationService

class LocationViewModel : ViewModel() {
    private val locationService: LocationService = LocationService()

    private val hints: SnapshotStateList<Location> = mutableStateListOf()
    private val query: MutableState<String> = mutableStateOf("")

    fun updateHints() {
        locationService.updateLocations(hints, query.value)
    }
}