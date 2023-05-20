package com.example.weatherapplication.ui.tab

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import com.example.weatherapplication.ui.layout.ForecastTabItem
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastTabContent(
    pagerState: PagerState,
    tabs: List<ForecastTabItem>,
) {
    HorizontalPager(state = pagerState) { page ->
        tabs[page].screen()
    }
}