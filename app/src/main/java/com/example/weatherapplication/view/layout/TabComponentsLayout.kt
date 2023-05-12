package com.example.weatherapplication.view.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.MainActivityViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalPagerApi
sealed class ForecastTabItem(
    val title: String,
    val content: @Composable (MainActivityViewModel) -> Unit
) {
    object Today : ForecastTabItem(
        title = "Today",
        content = {
            val list = remember { it.forecastHourly }
            ForecastContent(list = list, size = 8)
        }
    )

    object Tomorrow : ForecastTabItem(
        title = "Tomorrow",
        content = {
            val list = remember { it.forecastHourly }
            ForecastContent(list = list, size = 16)
        }
    )

    object Week : ForecastTabItem(
        title = "Week",
        content = {
            val list = remember { it.forecastHourly }
            ForecastContent(list = list, size = 40)
        }
    )
}

@ExperimentalPagerApi
@ExperimentalMaterialApi
@Composable
fun TabSelector(
    tabs: List<ForecastTabItem>,
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

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun TabContent(
    tabs: List<ForecastTabItem>,
    pagerState: PagerState,
    viewModel: MainActivityViewModel
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
            ForecastTabItem.Today,
            ForecastTabItem.Tomorrow,
            ForecastTabItem.Week
        )
        val pagerState = rememberPagerState(pageCount = tabs.size)
        Column {
            TabSelector(tabs = tabs, pagerState = pagerState)
            TabContent(tabs = tabs, pagerState = pagerState, MainActivityViewModel())
        }
    }
}