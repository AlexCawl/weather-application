package com.example.weatherapplication.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.weatherapplication.model.data.Place

@Composable
fun PlaceInfo(
    place: Place,
    cityRepresentationFunction: (Place) -> String
) {
    val text: String = cityRepresentationFunction(place)
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.background),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = MaterialTheme.colors.onBackground
    )
}