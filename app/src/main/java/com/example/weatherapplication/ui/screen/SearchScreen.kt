package com.example.weatherapplication.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
        val searchingText = remember { mutableStateOf("") }
        val listOfHints = remember { mutableStateOf(listOf<Location>()) }
        val onTextChangeEvent: (String) -> Unit = { searchingText.value = it }
        val onSearchPressedEvent: (String) -> Unit = {
            searchService.getLocations({ listOfHints.value = it }, searchingText.value)
        }

        Column {
            SearchEditText(onTextChangeEvent, onSearchPressedEvent)
            SearchItemListView(listOfHints)
        }
    }
}


@Preview
@Composable
fun PreviewMainScreen() {
    SearchScreen(SearchService()) { }
}