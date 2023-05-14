package com.example.weatherapplication.view.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Modifier
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.data.Weather
import com.example.weatherapplication.view.layout.MainScreenTopBar
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun MainScreen(
    viewModel: WeatherViewModel,
    onClickRefreshEvent: () -> Unit,
    onClickOptionsEvent: () -> Unit,
    cityRepresentationFunction: (Location) -> String,
    temperatureRepresentationFunction: (Forecast) -> String,
    weatherTypeRepresentationFunction: (Forecast) -> String,
    weatherSpeedRepresentationFunction: (Forecast) -> String,
    humidityRepresentationFunction: (Forecast) -> String,
    precipitationRepresentationFunction: (Forecast) -> String,
) {
    val resources: SnapshotStateMap<String, Weather> = remember { viewModel.locations }
    val content: List<@Composable () -> Unit> = resources.map { pair ->
        {
            WeatherScreen(
                screenIdentifier = pair.key, weather = pair.value,
                cityRepresentationFunction = cityRepresentationFunction,
                temperatureRepresentationFunction = temperatureRepresentationFunction,
                weatherTypeRepresentationFunction = weatherTypeRepresentationFunction,
                weatherSpeedRepresentationFunction = weatherSpeedRepresentationFunction,
                humidityRepresentationFunction = humidityRepresentationFunction,
                precipitationRepresentationFunction = precipitationRepresentationFunction
            )
        }
    }
    val pagerState = rememberPagerState(pageCount = resources.size)

    Scaffold(
        topBar = {
            MainScreenTopBar(onClickRefreshEvent, onClickOptionsEvent)
        }
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(it)
        ) { page ->
            content[page]()
        }
    }
}
