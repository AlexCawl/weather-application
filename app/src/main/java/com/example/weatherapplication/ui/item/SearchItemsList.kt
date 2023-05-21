package com.example.weatherapplication.ui.item

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.Location

@Composable
fun SearchItemsList(
    list: List<Location>,
    onClickEvent: (Location) -> Unit,
    modifier: Modifier = Modifier,
    gapSize: Dp = 5.dp
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(list) {
            SearchItem(
                cityName = it.name,
                latitude = it.latitude,
                longitude = it.longitude,
                regionName = it.countryCode,
                onClickEvent = { onClickEvent(it) })
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(gapSize))
        }
    }
}
