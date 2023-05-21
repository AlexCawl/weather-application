package com.example.weatherapplication.model

/**
 * Data class used to represent important data about some weather location.
 * */
data class Location(
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val countryCode: String
)