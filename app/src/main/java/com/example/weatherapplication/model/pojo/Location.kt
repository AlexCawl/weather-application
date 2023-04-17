package com.example.weatherapplication.model.pojo

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("name") val name: String,
    @SerializedName("local_names") val localNames: Map<String, String>,
    @SerializedName("lat") val latitude: Float,
    @SerializedName("lon") val longitude: Float,
    @SerializedName("country") val country: String,
    @SerializedName("state") val state: String?
)