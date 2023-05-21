package com.example.weatherapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapplication.service.ConverterService
import com.example.weatherapplication.ui.screen.MainScreen
import com.example.weatherapplication.ui.theme.WeatherApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by lazy {
        ViewModelProvider(this)[WeatherViewModel::class.java]
    }
    private val converter: ConverterService = ConverterService()

    @ExperimentalMaterialApi
    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContent {
            WeatherApplicationTheme {
                MainScreen(
                    viewModel = weatherViewModel,
                    converter = converter
                )
            }
        }
    }
}