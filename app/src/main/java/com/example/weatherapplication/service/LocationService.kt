package com.example.weatherapplication.service

import android.util.Log
import com.example.weatherapplication.exception.QueryValidationException
import com.example.weatherapplication.model.Location
import com.example.weatherapplication.retrofit.pojo.LocationPOJO
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

    fun updateLocations(list: MutableList<Location>, query: String) {
        try {
            val requestQuery: String = validateQuery(query)
            val call: Call<List<LocationPOJO>> = locationRepository.getLocationList(
                requestQuery,
                IdentifierService.hintLimit,
                IdentifierService.id
            )

            call.enqueue(object : Callback<List<LocationPOJO>> {
                override fun onResponse(
                    call: Call<List<LocationPOJO>>,
                    response: Response<List<LocationPOJO>>
                ) {
                    if (response.body() != null) {
                        list.clear()
                        list.addAll(
                            response.body().map {
                                Location(
                                    it.name,
                                    it.latitude,
                                    it.longitude,
                                    it.country
                                )
                            }
                        )
                    }
                }

                override fun onFailure(call: Call<List<LocationPOJO>>, t: Throwable) {
                    Log.println(Log.ERROR, this::class.java.toString(), t.stackTraceToString())
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