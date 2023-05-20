package com.example.weatherapplication.ui.item

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Position

@Composable
fun LocationItemsList(
    content: Map<String, Position>,
    cityRepresentationFunction: (Position) -> String,
    onClickRemoveEvent: (String) -> Unit,
    onClickRefreshEvent: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(content.toList()) {
            LocationItem(
                identifier = it.first,
                cityName = cityRepresentationFunction(it.second),
                onClickRemoveEvent = onClickRemoveEvent,
                onClickRefreshEvent = onClickRefreshEvent,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .height(5.dp)
            )
        }
    }
}