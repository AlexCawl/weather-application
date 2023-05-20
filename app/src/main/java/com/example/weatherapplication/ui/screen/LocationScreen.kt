package com.example.weatherapplication.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherapplication.ui.layout.LocationFloatingActionButton
import com.example.weatherapplication.ui.layout.LocationScreenTopBar
import com.example.weatherapplication.vm.WeatherViewModel

@Composable
fun LocationScreen(
    viewModel: WeatherViewModel,
    onClickReturnEvent: () -> Unit,
    onClickRefreshEvent: () -> Unit,
    onClickSettingsEvent: () -> Unit,
    onClickAddEvent: () -> Unit
) {
    Scaffold(
        topBar = {
            LocationScreenTopBar(
                onClickReturnEvent = onClickReturnEvent,
                onClickRefreshEvent = onClickRefreshEvent,
                onClickSettingsEvent = onClickSettingsEvent
            )
        },
        floatingActionButton = {
            LocationFloatingActionButton(
                onClickEvent = onClickAddEvent
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {

        }
    }
}
