package com.example.weatherapplication.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
    onClickOptionsEvent: () -> Unit = {},
    onClickRefreshEvent: () -> Unit = {},
) {
    val resources: List<WeatherScreenItem> = viewModel.locations
        .map { pair -> WeatherScreenItem(pair.key) { WeatherScreen(pair.value) } }
    val namespaces: List<String> = viewModel.locations.keys.toList()
    val pagerState = rememberPagerState(pageCount = resources.size)

    Scaffold(
        topBar = {
            MainScreenTopBar(pagerState, namespaces, onClickOptionsEvent, onClickRefreshEvent)
        }
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(it)
        ) { page ->
//            resources[page].content()
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue))
        }
    }
}

data class WeatherScreenItem(val name: String, val content: @Composable () -> Unit)