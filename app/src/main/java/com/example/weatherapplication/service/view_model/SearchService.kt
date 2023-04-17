package com.example.weatherapplication.service.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.weatherapplication.model.pojo.Location
import com.example.weatherapplication.model.retrofit.LocationService
import com.example.weatherapplication.model.retrofit.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchService : ViewModel() {
    private val locationService: LocationService = RetrofitFactory
        .getInstance()
        .create(LocationService::class.java)

    private val apiKey: String = "05668a5140f7153f74f85c448be1ca22"
    private val limit: Int = 5

    fun getLocations(onGetLocationsEvent: (List<Location>) -> Unit, name: String) {
        val call = locationService.getLocations(name, limit, apiKey)
        call.enqueue(object : Callback<List<Location>> {
            override fun onResponse(call: Call<List<Location>>, response: Response<List<Location>>) {
                Log.println(
                    Log.INFO,
                    this::class.java.toString(),
                    "${response.code()} ${response.message()} ${response.body()}"
                )
                onGetLocationsEvent(response.body())
            }

            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
                Log.println(
                    Log.ERROR,
                    this::class.java.toString(),
                    t.stackTraceToString()
                )
                call.cancel()
            }
        })
    }
}