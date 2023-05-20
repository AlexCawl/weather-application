package com.example.weatherapplication.model.data

import com.google.gson.annotations.SerializedName

data class Position(
    @SerializedName("name") val name: String,
    @SerializedName("local_names") val localNames: Map<String, String>,
    @SerializedName("lat") val latitude: Double,
    @SerializedName("lon") val longitude: Double,
    @SerializedName("country") val country: String,
    @SerializedName("state") val state: String?
)