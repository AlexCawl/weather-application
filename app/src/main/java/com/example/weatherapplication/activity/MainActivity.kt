package com.example.weatherapplication.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.view.screen.MainScreen
import com.example.weatherapplication.view.screen.WeatherScreen
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by lazy {
        ViewModelProvider(this)[WeatherViewModel::class.java]
    }

    @ExperimentalMaterialApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContent {
            WeatherApplicationTheme {
                MainScreen(
                    viewModel = weatherViewModel,
                    {},
                    {},
                    { "Moscow" },
                    {"18°"},
                    {"Cloudy"},
                    {"10 m/s"},
                    {"65 %"},
                    {"73 %"},
                )
            }
        }
    }
}