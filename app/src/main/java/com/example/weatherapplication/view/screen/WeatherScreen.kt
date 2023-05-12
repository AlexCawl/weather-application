package com.example.weatherapplication.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Weather
import com.example.weatherapplication.view.layout.ForecastInfo
import com.example.weatherapplication.view.layout.MainScreenTopBar
import com.example.weatherapplication.view.layout.TemperatureInfo
import com.example.weatherapplication.view.layout.WeatherInfo
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun WeatherScreen(
    weather: Weather,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .padding(15.dp)
    ) {
        Column {
            TemperatureInfo(WeatherViewModel())
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
            )
            WeatherInfo(WeatherViewModel())
            Spacer(
                modifier = Modifier
                    .height(15.dp)
                    .fillMaxWidth()
            )
            ForecastInfo(WeatherViewModel())
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    WeatherApplicationTheme {
//        MainScreen()
    }
}