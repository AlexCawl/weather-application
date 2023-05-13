package com.example.weatherapplication.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.view.layout.LocationScreenTopBar
import com.example.weatherapplication.view.layout.SearchBar
import com.example.weatherapplication.view.theme.WeatherApplicationTheme

@Composable
fun LocationScreen(
    onClickReturnEvent: () -> Unit,
    onClickRefreshEvent: () -> Unit,
    onClickSettingsEvent: () -> Unit,
) {
    Scaffold(
        topBar = {
            LocationScreenTopBar(
                onClickReturnEvent = onClickReturnEvent,
                onClickRefreshEvent = onClickRefreshEvent,
                onClickSettingsEvent = onClickSettingsEvent
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            SearchBar(
                onTextChangeEvent = {},
                unfocusedColor = MaterialTheme.colors.onSurface,
                focusedColor = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .background(
                        color = MaterialTheme.colors.surface,
                        shape = RoundedCornerShape(15.dp)
                    )
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LocationScreenPreview() {
    WeatherApplicationTheme {
        LocationScreen(
            onClickReturnEvent = { /*TODO*/ },
            onClickRefreshEvent = { /*TODO*/ },
            onClickSettingsEvent = { /*TODO*/ },
        )
    }
}