package com.example.weatherapplication.model.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherCallback<R, C>(
    private val content: C,
    private val mappingFunc: (Response<R>, C) -> Unit
) : Callback<R> {
    override fun onResponse(call: Call<R>, response: Response<R>) {
        Log.println(
            Log.INFO,
            this::class.java.toString(),
            "${response.code()} ${response.message()} ${response.body()}"
        )
        if (response.body() != null) {
            mappingFunc(response, content)
        }
    }

    override fun onFailure(call: Call<R>, t: Throwable) {
        Log.println(
            Log.ERROR,
            this::class.java.toString(),
            t.stackTraceToString()
        )
        call.cancel()
    }

}