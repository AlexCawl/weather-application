package com.example.weatherapplication.retrofit.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RepositoryFactory {
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