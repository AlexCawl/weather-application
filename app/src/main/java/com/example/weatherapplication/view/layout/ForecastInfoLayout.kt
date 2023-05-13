package com.example.weatherapplication.view.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastInfo(
    content: List<Forecast>
) {
    val tabs = listOf(
        ForecastTabItem("Today") { ForecastContent(list = content, range = (0 until 8)) },
        ForecastTabItem("Tomorrow") { ForecastContent(list = content, range = (8 until 16)) },
        ForecastTabItem("Week") { ForecastContent(list = content, range = (16 until 40)) },
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    Column {
        TabSelector(tabs = tabs, pagerState = pagerState)
        Spacer(modifier = Modifier
            .height(5.dp)
            .fillMaxWidth())
        TabContent(pagerState = pagerState, tabs = tabs)
    }
}