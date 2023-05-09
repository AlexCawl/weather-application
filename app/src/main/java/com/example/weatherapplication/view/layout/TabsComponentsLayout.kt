package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

sealed class WeatherForecastTabItem(
    val title: String,
    val content: @Composable (WeatherViewModel) -> Unit
) {
    object Now : WeatherForecastTabItem(
        title = "Now",
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red))
        }
    )

    object Tomorrow : WeatherForecastTabItem(
        title = "Tomorrow",
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Blue))
        }
    )

    object Week : WeatherForecastTabItem(
        title = "Week",
        content = {
            Box(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Green))
        }
    )
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun TabSelector(
    tabs: List<WeatherForecastTabItem>,
    pagerState: PagerState
) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }
    ) {
        tabs.forEachIndexed { index, tab ->
            Tab(
                text = { Text(tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@ExperimentalPagerApi
@Composable
fun TabContent(
    tabs: List<WeatherForecastTabItem>,
    pagerState: PagerState,
    viewModel: WeatherViewModel
) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].content(viewModel)
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TabsPreview() {
    WeatherApplicationTheme {
        val tabs = listOf(
            WeatherForecastTabItem.Now,
            WeatherForecastTabItem.Tomorrow,
            WeatherForecastTabItem.Week
        )
        val pagerState = rememberPagerState(pageCount = tabs.size)
        Column {
            TabSelector(tabs = tabs, pagerState = pagerState)
            TabContent(tabs = tabs, pagerState = pagerState, WeatherViewModel())
        }
    }
}