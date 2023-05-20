package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.ui.item.ForecastItemsList
import com.example.weatherapplication.ui.tab.ForecastTabContent
import com.example.weatherapplication.ui.tab.ForecastTabSelector
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastInfoView(
    content: List<Forecast>,
    dateTimeRepresentationFunction: (Forecast) -> String,
    minMaxTemperatureRepresentationFunction: (Forecast) -> Pair<String, String>
) {
    val tabs = listOf(
        ForecastTabItem("Today") {
            ForecastItemsList(
                list = content,
                range = (0 until 8),
                dateTimeRepresentationFunction = dateTimeRepresentationFunction,
                minMaxTemperatureRepresentationFunction = minMaxTemperatureRepresentationFunction
            )
        },
        ForecastTabItem("Tomorrow") {
            ForecastItemsList(
                list = content,
                range = (8 until 16),
                dateTimeRepresentationFunction = dateTimeRepresentationFunction,
                minMaxTemperatureRepresentationFunction = minMaxTemperatureRepresentationFunction
            )
        },
        ForecastTabItem("Week") {
            ForecastItemsList(
                list = content,
                range = (16 until 40),
                dateTimeRepresentationFunction = dateTimeRepresentationFunction,
                minMaxTemperatureRepresentationFunction = minMaxTemperatureRepresentationFunction
            )
        },
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    Column {
        ForecastTabSelector(tabs = tabs, pagerState = pagerState)
        Spacer(
            modifier = Modifier
                .height(5.dp)
                .fillMaxWidth()
        )
        ForecastTabContent(pagerState = pagerState, tabs = tabs)
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
class ForecastTabItem(val title: String, val screen: @Composable () -> Unit)