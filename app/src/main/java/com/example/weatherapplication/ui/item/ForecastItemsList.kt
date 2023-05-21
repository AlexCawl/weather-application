package com.example.weatherapplication.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.Forecast
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastItemsList(
    list: List<Forecast>,
    range: IntRange,
    getDatetime: (Forecast) -> Pair<String, String>,
    getTemperature: (Forecast) -> String,
    getPrecipitation: (Forecast) -> String,
    getIconID: (Forecast) -> Int
) {
    val content = mutableListOf<Forecast>()
    val indices = list.indices
    range.forEach {
        if (it in indices) {
            content.add(list[it])
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(5.dp))
            .padding(5.dp)
    ) {
        LazyColumn {
            items(content) {
                ForecastItem(
                    datetime = getDatetime(it),
                    temperature = getTemperature(it),
                    precipitationProbability = getPrecipitation(it),
                    barFillingPercent = it.precipitationProbability.toFloat(),
                    iconID = getIconID(it),
                )
            }
        }
    }
}
