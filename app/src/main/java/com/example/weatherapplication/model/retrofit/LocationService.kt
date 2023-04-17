package com.example.weatherapplication.model.retrofit

import com.example.weatherapplication.model.pojo.Location
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationService {
    @GET("geo/1.0/direct")
    fun getLocations(@Query("q") name: String, @Query("limit") limit: Int = 5, @Query("appid") id: String): Call<List<Location>>
}