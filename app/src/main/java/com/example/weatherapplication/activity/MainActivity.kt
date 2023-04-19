package com.example.weatherapplication.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.view.layout.WeatherNavigationHost
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.LocationViewModel
import com.example.weatherapplication.view_model.WeatherViewModel

class MainActivity : ComponentActivity() {
    private val locationViewModel: LocationViewModel by lazy {
        ViewModelProvider(this)[LocationViewModel::class.java]
    }
    private val weatherViewModel: WeatherViewModel by lazy {
        ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherApplicationTheme {
                WeatherNavigationHost(
                    locationManager = locationViewModel,
                    weatherManager = weatherViewModel,
                )
            }
        }
    }
}