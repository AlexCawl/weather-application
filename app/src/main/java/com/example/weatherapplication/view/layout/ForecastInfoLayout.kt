package com.example.weatherapplication.view.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.view_model.MainActivityViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastInfo(
    viewModel: MainActivityViewModel
) {
    val tabs = listOf(
        ForecastTabItem.Today,
        ForecastTabItem.Tomorrow,
        ForecastTabItem.Week
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    Column {
        TabSelector(tabs = tabs, pagerState = pagerState)
        Spacer(modifier = Modifier
            .height(5.dp)
            .fillMaxWidth())
        TabContent(tabs = tabs, pagerState = pagerState, viewModel = viewModel)
    }
}