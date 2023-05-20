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
import com.example.weatherapplication.model.data.Forecast
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlin.math.abs

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastItemsList(
    list: List<Forecast>,
    range: IntRange,
    dateTimeRepresentationFunction: (Forecast) -> String,
    minMaxTemperatureRepresentationFunction: (Forecast) -> Pair<String, String>
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
            val (minTemp: Double, maxTemp: Double) = content.fold(
                Pair(Double.MAX_VALUE, Double.MIN_VALUE)
            ) { pair, forecast ->
                when {
                    forecast.temperatureMinimum < pair.first && forecast.temperatureMaximum > pair.second -> Pair(
                        forecast.temperatureMinimum, forecast.temperatureMaximum
                    )
                    forecast.temperatureMinimum < pair.first -> Pair(
                        forecast.temperatureMinimum, pair.second
                    )
                    forecast.temperatureMaximum > pair.second -> Pair(
                        pair.first, forecast.temperatureMaximum
                    )
                    else -> pair
                }
            }
            val sizeOfBar: Double = abs(maxTemp - minTemp)

            items(content) {
                val time = dateTimeRepresentationFunction(it)
                val temperature = minMaxTemperatureRepresentationFunction(it)
                val progress: Pair<Float, Float> = Pair(
                    (abs(it.temperatureMinimum - minTemp) / sizeOfBar).toFloat(),
                    (abs(it.temperatureMaximum - minTemp) / sizeOfBar).toFloat()
                )
                ForecastItem(
                    definition = time,
                    temperatureMin = temperature.first,
                    temperatureMax = temperature.second,
                    barFillingData = progress,
                    weatherTypeIconID = com.example.weatherapplication.R.drawable.round_cloud_24,
                )
            }
        }
    }
}
