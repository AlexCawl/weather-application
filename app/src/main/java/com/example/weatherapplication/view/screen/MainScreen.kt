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
import com.example.weatherapplication.view.layout.WeatherInfo
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.MainActivityViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun MainScreen(
    viewModel: MainActivityViewModel = MainActivityViewModel()
) {
    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = { MainScreenTopBar(viewModel) }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(15.dp)
        ) {
            Column {
                TemperatureInfo(viewModel)
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
                WeatherInfo(viewModel)
                Spacer(
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth()
                )
                ForecastInfo(viewModel)
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