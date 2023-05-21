package com.example.weatherapplication.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Position
import com.example.weatherapplication.ui.item.SearchItemsList
import com.example.weatherapplication.ui.layout.SearchBarView
import com.example.weatherapplication.ui.layout.SearchScreenTopBar
import com.example.weatherapplication.vm.WeatherViewModel

@Composable
fun SearchScreen(
    viewModel: WeatherViewModel,
    onClickReturnEvent: () -> Unit,
) {
    val hints: SnapshotStateList<Position> = remember { mutableStateListOf() }
    val query: MutableState<String> = remember { mutableStateOf("") }

    Scaffold(topBar = {
        SearchScreenTopBar(
            onClickReturnEvent = onClickReturnEvent
        )
    }) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            SearchBarView(
                onTextChangeEvent = { text ->
                    query.value = text
                    viewModel.updateHints(hints, query)
                },
                unfocusedColor = MaterialTheme.colors.onSurface,
                focusedColor = MaterialTheme.colors.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(5.dp)),
                onClearClickedEvent = { hints.clear() }
            )
            SearchItemsList(
                list = hints,
                onClickEvent = { position ->
                    viewModel.addLocation(position)
                    onClickReturnEvent()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
            )
        }
    }
}