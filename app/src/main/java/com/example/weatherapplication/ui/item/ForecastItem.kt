package com.example.weatherapplication.ui.item

import androidx.annotation.DrawableRes
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.ui.layout.GradientBarView

@Composable
fun ForecastItem(
    datetime: Pair<String, String>,
    temperature: String,
    precipitationProbability: String,
    barFillingPercent: Float,
    @DrawableRes iconID: Int
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
        Column(
            modifier = Modifier.width(130.dp)
        ) {
            Text(
                text = datetime.first,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = datetime.second,
                color = MaterialTheme.colors.onBackground,
                overflow = TextOverflow.Ellipsis
            )
        }
        Text(
            text = temperature,
            modifier = Modifier
                .width(50.dp)
                .fillMaxHeight()
                .background(
                    color = MaterialTheme.colors.background,
                    shape = RoundedCornerShape(15.dp)
                )
                .wrapContentHeight(),
            fontSize = 20.sp,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.weight(1f, true))
        Column(
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight()
                .background(color = MaterialTheme.colors.background, shape = RoundedCornerShape(15.dp))
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GradientBarView(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp),
                progress = barFillingPercent
            )
            Text(
                text = precipitationProbability,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.weight(1f, true))
        Icon(
            imageVector = ImageVector.vectorResource(id = iconID),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground,
            modifier = Modifier.width(50.dp).height(50.dp)
        )
    }
}