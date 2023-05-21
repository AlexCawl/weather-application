package com.example.weatherapplication.service

import android.util.Log
import com.example.weatherapplication.retrofit.pojo.Position
import com.example.weatherapplication.exception.QueryValidationException
import com.example.weatherapplication.retrofit.repository.LocationRepository
import com.example.weatherapplication.retrofit.repository.RepositoryFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationService {
    private val locationRepository: LocationRepository = RepositoryFactory
        .getInstance()
        .create(LocationRepository::class.java)

    @Throws(QueryValidationException::class)
    private fun validateQuery(query: String): String {
        return when {
            query.isEmpty() -> throw QueryValidationException("Empty query", query)
            query.isBlank() -> throw QueryValidationException("Blank query", query)
            else -> {
                query.trim()
            }
        }
    }

    fun updateLocations(list: MutableList<Position>, query: String) {
        try {
            val requestQuery: String = validateQuery(query)
            val call: Call<List<Position>> = locationRepository
                .getLocationList(requestQuery, IdentifierService.hintLimit, IdentifierService.id)

            call.enqueue(object : Callback<List<Position>> {
                override fun onResponse(call: Call<List<Position>>, response: Response<List<Position>>) {
                    Log.println(
                        Log.INFO,
                        this::class.java.toString(),
                        "${response.code()} ${response.message()} ${response.body()}"
                    )
                    if (response.body() != null) {
                        list.clear()
                        list.addAll(response.body())
                    }
                }

                override fun onFailure(call: Call<List<Position>>, t: Throwable) {
                    Log.println(
                        Log.ERROR,
                        this::class.java.toString(),
                        t.stackTraceToString()
                    )
                    call.cancel()
                }
            })
        } catch (exception: QueryValidationException) {
            Log.println(Log.WARN, this::class.toString(), exception.localizedMessage)
        } catch (exception: Exception) {
            Log.println(Log.ERROR, this::class.toString(), exception.stackTraceToString())
        }
    }
}