package com.example.weatherapplication.ui.item

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.weatherapplication.model.data.Position

@Composable
fun SearchItemsList(
    list: List<Position>,
    onClickEvent: (Position) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) {
            SearchItem(
                cityName = it.name,
                latitude = it.latitude,
                longitude = it.longitude,
                regionName = it.country,
                onClickEvent = { onClickEvent(it) })
        }
    }
}
