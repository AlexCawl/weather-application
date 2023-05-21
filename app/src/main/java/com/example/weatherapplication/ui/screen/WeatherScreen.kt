package com.example.weatherapplication.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.weatherapplication.android.WeatherViewModel
import com.example.weatherapplication.service.ConverterService
import com.example.weatherapplication.ui.layout.MainScreenTopBar
import com.example.weatherapplication.ui.layout.WeatherView
import com.example.weatherapplication.ui.theme.ComposableFunction
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
    val resources = remember { viewModel.locations }
    val content: List<ComposableFunction> = resources.map { pair ->
        {
            WeatherView(
                weather = pair.value,
                getCity = { converter.getCityName(it) },
                getTemperature = { converter.getTemperature(it) },
                getWeatherType = { converter.getWeatherType(it) },
                getWindSpeed = { converter.getWeatherSpeed(it) },
                getHumidity = { converter.getHumidity(it) },
                getCloudiness = { converter.getCloudiness(it) },
                getDatetime = { converter.getTime(it) },
                getPrecipitation = { converter.getPrecipitation(it) },
                getIconID = { converter.getIconID(it) }
            )
        }
    }
    val pagerState = rememberPagerState(pageCount = resources.size)

    Scaffold(
        topBar = {
            MainScreenTopBar(converter, onClickRefreshEvent, onClickOptionsEvent)
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
