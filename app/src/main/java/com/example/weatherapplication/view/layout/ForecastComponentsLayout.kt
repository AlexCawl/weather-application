package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Forecast
import com.google.accompanist.pager.ExperimentalPagerApi
import kotlin.math.abs

@Composable
fun ForecastItem(
    definition: String,
    temperatureMin: String,
    temperatureMax: String,
    barFillingData: Pair<Float, Float>,
    weatherTypeIconID: Int
) {
    Row(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(5.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.width(100.dp),
            text = definition,
            color = MaterialTheme.colors.onBackground,
        )
        Row(
            modifier = Modifier.width(160.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = temperatureMin,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.width(30.dp),
                textAlign = TextAlign.End,
            )
            GradientBar(
                indent = barFillingData.first,
                progress = barFillingData.second,
                modifier = Modifier
                    .width(100.dp)
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            Text(
                text = temperatureMax,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.width(30.dp),
                textAlign = TextAlign.Start
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))
        Icon(
            imageVector = ImageVector.vectorResource(id = weatherTypeIconID),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground
        )
    }
}

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastContent(
    list: List<Forecast>,
    size: Int
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(5.dp))
            .padding(5.dp)
    ) {
        LazyColumn {
            val (minTemp: Double, maxTemp: Double) = list.take(size).fold(
                Pair(Double.MAX_VALUE, Double.MIN_VALUE)
            ) { pair, forecast ->
                return@fold when {
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
            items(list.take(size)) {
                val time = it.getTime(true)
                val temperature = it.getTemperature()
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
