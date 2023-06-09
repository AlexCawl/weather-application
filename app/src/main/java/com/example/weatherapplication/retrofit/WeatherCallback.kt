package com.example.weatherapplication.retrofit

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherCallback<R, C>(
    private val content: C,
    private val mappingFunc: (Response<R>, C) -> Unit
): Callback<R> {
    override fun onResponse(call: Call<R>, response: Response<R>) {
        if (response.body() != null) {
            mappingFunc(response, content)
        }
    }

    override fun onFailure(call: Call<R>, t: Throwable) {
        Log.println(Log.ERROR, this::class.java.toString(), t.stackTraceToString())
        call.cancel()
    }

}