package com.example.weatherapplication.view_model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.data.Place
import com.example.weatherapplication.model.service.PlaceService

class LocationViewModel : ViewModel() {
    private val placeService: PlaceService = PlaceService()

    private val hints: SnapshotStateList<Place> = mutableStateListOf()
    private val query: MutableState<String> = mutableStateOf("")

    fun updateHints() {
        placeService.updateLocations(hints, query.value)
    }
}