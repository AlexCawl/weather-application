package com.example.weatherapplication.model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        private const val baseURL: String = "http://api.openweathermap.org/"
        private val connector: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getInstance(): Retrofit {
            return connector
        }
    }
}