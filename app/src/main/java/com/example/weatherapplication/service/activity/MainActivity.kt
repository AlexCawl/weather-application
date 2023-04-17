package com.example.weatherapplication.service.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherapplication.service.view_model.SearchService
import com.example.weatherapplication.ui.layout.WeatherNavigationHost
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme

class MainActivity : ComponentActivity() {
    private val searchService: SearchService = SearchService()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WeatherApplicationTheme {
                WeatherNavigationHost(searchService = searchService)
            }
        }
    }
}