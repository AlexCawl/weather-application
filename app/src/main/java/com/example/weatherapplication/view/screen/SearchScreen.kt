package com.example.weatherapplication.view.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.model.data.Location
import com.example.weatherapplication.view.layout.*
import com.example.weatherapplication.view_model.LocationViewModel
import com.example.weatherapplication.view_model.WeatherViewModel

@Composable
fun SearchScreen(
    locationManager: LocationViewModel,
    weatherManager: WeatherViewModel,
    onNavigationItemSelected: (Screen) -> Unit
) {
    Scaffold(bottomBar = {
        WeatherBottomAppBar(onNavigationItemSelected = onNavigationItemSelected)
    }) {
        val query: MutableState<String> = remember { locationManager.query }
        val hints: SnapshotStateList<Location> = remember { locationManager.hints }

        Column(
            modifier = Modifier.padding(it)
        ) {
            SearchEditText(
                query = query,
                onSearchPressedEvent = {
                    locationManager.updateHints()
                },
                onClearPressedEvent = {
                    locationManager.hints.clear()
                },
                onTextChangedEvent = {
                    locationManager.updateHints()
                }
            )
            SearchItemListView(
                hints = hints,
                onClickEvent = { location ->
                    weatherManager.updateCurrentWeather(location)
                    locationManager.hints.clear()
                    locationManager.query.value = ""
                }
            )
            WeatherView(
                weatherManager = weatherManager
            )
        }
    }
}


@Preview
@Composable
fun PreviewMainScreen() {
//    SearchScreen(SearchService()) { }
}