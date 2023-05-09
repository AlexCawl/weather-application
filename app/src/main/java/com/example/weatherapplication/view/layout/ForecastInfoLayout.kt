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
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.weatherapplication.model.data.Forecast
import com.example.weatherapplication.view.theme.WeatherApplicationTheme
import com.example.weatherapplication.view_model.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import java.time.LocalDateTime
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
            .padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.width(100.dp),
            text = definition,
            color = MaterialTheme.colors.onBackground,
        )
        Row(
            modifier = Modifier.width(250.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = temperatureMin,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.width(50.dp),
                textAlign = TextAlign.End,
            )
            GradientWeatherStatistic(
                indent = barFillingData.first,
                progress = barFillingData.second,
                modifier = Modifier
                    .width(140.dp)
                    .fillMaxHeight()
                    .padding(10.dp)
            )
            Text(
                text = temperatureMax,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.width(50.dp),
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

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WeatherForecastContentPreview() {
    WeatherApplicationTheme {
        Column {
            ForecastItem(
                "00:00",
                "-10°",
                "-2°",
                Pair(0.3f, 0.5f),
                com.example.weatherapplication.R.drawable.round_cloud_24
            )
            ForecastItem(
                "01:00",
                "-8°",
                "1°",
                Pair(0.1f, 0.8f),
                com.example.weatherapplication.R.drawable.round_cloud_24
            )
        }
    }
}

@Composable
fun TabContent(
    list: SnapshotStateList<Forecast>
) {
    LazyColumn {
        val (minTemp: Double, maxTemp: Double) = list.fold(
            Pair(list[0].temperatureMinimum, list[0].temperatureMaximum)
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
        items(list) {
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

@ExperimentalMaterialApi
@ExperimentalPagerApi
@Composable
fun ForecastInfo() {
    val tabs = listOf(
        WeatherForecastTabItem.Now,
        WeatherForecastTabItem.Tomorrow,
        WeatherForecastTabItem.Week
    )
    val pagerState = rememberPagerState(pageCount = tabs.size)
    Column {
        TabSelector(tabs = tabs, pagerState = pagerState)
        Spacer(
            modifier = Modifier
                .height(5.dp)
                .fillMaxWidth()
        )
        TabContent(tabs = tabs, pagerState = pagerState, WeatherViewModel())
    }
}

@Preview
@Composable
fun WeatherForecastForWeekContentPreview() {
    val list = remember {
        mutableStateListOf(
            Forecast(
                "Moscow",
                1.0,
                1.0,
                5.0,
                -1.0,
                6.0,
                55,
                10.0,
                67, LocalDateTime.now()
            ),
            Forecast(
                "Moscow",
                1.0,
                1.0,
                5.0,
                -5.0,
                7.0,
                55,
                10.0,
                67, LocalDateTime.now()
            ),
            Forecast(
                "Moscow",
                1.0,
                1.0,
                5.0,
                -3.0,
                2.0,
                55,
                10.0,
                67, LocalDateTime.now()
            ),
        )
    }
    WeatherApplicationTheme {
        TabContent(list = list)
    }
}