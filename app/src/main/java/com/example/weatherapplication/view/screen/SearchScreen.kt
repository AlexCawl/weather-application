package com.example.weatherapplication.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.weatherapplication.view.layout.SearchBar
import com.example.weatherapplication.view.layout.SearchHintContent
import com.example.weatherapplication.view.layout.SearchScreenTopBar
import com.example.weatherapplication.view_model.LocationViewModel

@Composable
fun SearchScreen(
    viewModel: LocationViewModel,
    onClickReturnEvent: () -> Unit,
) {
    val query = remember { viewModel.query }
    val hints = remember { viewModel.hints }
    Scaffold(
        topBar = {
            SearchScreenTopBar(
                onClickReturnEvent = onClickReturnEvent
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            SearchBar(
                onTextChangeEvent = { text ->
                    query.value = text
                    viewModel.updateHints()
                },
                unfocusedColor = MaterialTheme.colors.onSurface,
                focusedColor = MaterialTheme.colors.onBackground
            )
            SearchHintContent(
                list = hints,
                onClickEvent = { /*TODO()*/ }
            )
        }
    }
}