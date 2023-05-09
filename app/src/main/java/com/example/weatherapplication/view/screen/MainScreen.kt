package com.example.weatherapplication.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.view.layout.ForecastInfo
import com.example.weatherapplication.view.layout.MainScreenTopBar
import com.example.weatherapplication.view.layout.TemperatureInfo
import com.example.weatherapplication.view.layout.WeatherInfoBar
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun MainScreen() {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = { MainScreenTopBar() }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(15.dp)
        ) {
            Column {
                TemperatureInfo()
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
                WeatherInfoBar()
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
                ForecastInfo()
            }
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    WeatherApplicationTheme {
        MainScreen()
    }
}