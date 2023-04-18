package com.example.weatherapplication.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.model.pojo.Location
import com.example.weatherapplication.service.view_model.SearchService
import com.example.weatherapplication.ui.layout.Screen
import com.example.weatherapplication.ui.layout.SearchEditText
import com.example.weatherapplication.ui.layout.SearchItemListView
import com.example.weatherapplication.ui.layout.WeatherBottomAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SearchScreen(
    searchService: SearchService, onNavigationItemSelected: (Screen) -> Unit
) {
    Scaffold(bottomBar = {
        WeatherBottomAppBar(onNavigationItemSelected = onNavigationItemSelected)
    }) {
        val searchQuery: MutableState<String> = remember { searchService.searchQuery }
        val listOfHints: SnapshotStateList<Location> = remember { searchService.listOfHints }

        Column {
            SearchEditText(
                query = searchQuery,
                onSearchPressedEvent = {
                    searchService.updateLocationHints()
                },
                onClearPressedEvent = {
                    searchService.listOfHints.clear()
                },
                onTextChangedEvent = {
                    searchService.updateLocationHints()
                }
            )
            SearchItemListView(listOfHints)
        }
    }
}


@Preview
@Composable
fun PreviewMainScreen() {
    SearchScreen(SearchService()) { }
}