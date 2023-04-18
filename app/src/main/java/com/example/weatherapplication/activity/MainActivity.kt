package com.example.weatherapplication.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.view.layout.WeatherNavigationHost
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.LocationViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: LocationViewModel by lazy {
        ViewModelProvider(this)[LocationViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherApplicationTheme {
                WeatherNavigationHost(
                    locationManager = viewModel
                )
            }
        }
    }
}