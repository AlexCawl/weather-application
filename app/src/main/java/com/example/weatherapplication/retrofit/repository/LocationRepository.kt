package com.example.weatherapplication.retrofit.repository

import com.example.weatherapplication.retrofit.pojo.Position
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationRepository {
    @GET("geo/1.0/direct")
    fun getLocationList(
        @Query("q") name: String,
        @Query("limit") limit: Int = 5,
        @Query("appid") id: String
    ): Call<List<Position>>
}