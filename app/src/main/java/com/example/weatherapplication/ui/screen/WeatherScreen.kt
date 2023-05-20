package com.example.weatherapplication.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.compose.ui.Modifier
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.model.service.ConverterService
import com.example.weatherapplication.ui.layout.MainScreenTopBar
import com.example.weatherapplication.ui.layout.WeatherView
import com.example.weatherapplication.ui.theme.ComposableFunction
import com.example.weatherapplication.vm.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel,
    converter: ConverterService,
    onClickRefreshEvent: () -> Unit,
    onClickOptionsEvent: () -> Unit
) {
    val resources: SnapshotStateMap<String, Location> = remember { viewModel.locations }
    val content: List<ComposableFunction> = resources.map { pair ->
        {
            WeatherView(
                screenIdentifier = pair.key, location = pair.value,
                cityRepresentationFunction = { converter.getCityName(it) },
                temperatureRepresentationFunction = { converter.getTemperature(it) },
                weatherTypeRepresentationFunction = { converter.getWeatherType(it) },
                weatherSpeedRepresentationFunction = { converter.getWeatherSpeed(it) },
                humidityRepresentationFunction = { converter.getHumidity(it) },
                precipitationRepresentationFunction = { converter.getPrecipitation(it) },
                dateTimeRepresentationFunction = { converter.getTime(it) },
                minMaxTemperatureRepresentationFunction = { converter.getPairTemperature(it) }
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