package com.example.weatherapplication.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.weatherapplication.model.service.ConverterService
import com.example.weatherapplication.ui.item.LocationItemsList
import com.example.weatherapplication.ui.layout.LocationFloatingActionButton
import com.example.weatherapplication.ui.layout.LocationScreenTopBar
import com.example.weatherapplication.vm.WeatherViewModel

@Composable
fun LocationScreen(
    viewModel: WeatherViewModel,
    onClickReturnEvent: () -> Unit,
    onClickRefreshEvent: () -> Unit,
    onClickSettingsEvent: () -> Unit,
    onClickAddEvent: () -> Unit,
    converter: ConverterService
) {
    val content = remember { viewModel.locations }
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
        LocationItemsList(
            modifier = Modifier.padding(it),
            content = content.mapValues { entry ->  entry.value.position.value },
            cityRepresentationFunction = { position ->
                converter.getCityName(position)
            },
            onClickRemoveEvent = { identifier ->
                viewModel.removeLocation(identifier)
            },
            onClickRefreshEvent = { identifier ->
                viewModel.refreshData(identifier)
            }
        )
    }
}
