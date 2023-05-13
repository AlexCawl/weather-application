package com.example.weatherapplication.view.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@ExperimentalPagerApi
class ForecastTabItem(val title: String, val screen: @Composable () -> Unit)

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
    pagerState: PagerState,
    tabs: List<ForecastTabItem>,
) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}
