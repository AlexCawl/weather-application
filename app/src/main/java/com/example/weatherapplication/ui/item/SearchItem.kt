package com.example.weatherapplication.ui.item

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchItem(
    cityName: String,
    latitude: Double,
    longitude: Double,
    regionName: String,
    onClickEvent: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.surface, shape = RoundedCornerShape(15.dp))
            .padding(10.dp)
            .clickable { onClickEvent() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = cityName,
            color = MaterialTheme.colors.onBackground,
            fontSize = 18.sp,
            modifier = Modifier.width(150.dp),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(20.dp))
        Row(
            modifier = Modifier
                .width(120.dp)
                .background(
                    color = MaterialTheme.colors.background,
                    shape = RoundedCornerShape(10.dp)
                )
                .padding(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "lat",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
                Text(
                    text = "%.1f".format(latitude),
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "lon",
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
                Text(
                    text = "%.1f".format(longitude),
                    color = MaterialTheme.colors.onSurface,
                    fontSize = 16.sp,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f, true))
        Text(
            text = regionName,
            color = MaterialTheme.colors.onBackground,
            fontSize = 18.sp,
            maxLines = 1
        )
    }
}