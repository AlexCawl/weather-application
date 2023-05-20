package com.example.weatherapplication.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.weatherapplication.ui.item.SearchItemsList
import com.example.weatherapplication.ui.layout.SearchBarView
import com.example.weatherapplication.ui.layout.SearchScreenTopBar
import com.example.weatherapplication.vm.LocationViewModel

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
            SearchBarView(
                onTextChangeEvent = { text ->
                    query.value = text
                    viewModel.updateHints()
                },
                unfocusedColor = MaterialTheme.colors.onSurface,
                focusedColor = MaterialTheme.colors.onBackground
            )
            SearchItemsList(
                list = hints,
                onClickEvent = { /*TODO()*/ }
            )
        }
    }
}