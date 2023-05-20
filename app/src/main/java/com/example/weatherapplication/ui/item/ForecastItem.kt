package com.example.weatherapplication.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.weatherapplication.ui.layout.GradientBarView

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
            GradientBarView(
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