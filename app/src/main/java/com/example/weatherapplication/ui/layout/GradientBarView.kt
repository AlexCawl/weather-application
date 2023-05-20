package com.example.weatherapplication.ui.layout

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun GradientBarView(
    progress: Float,
    modifier: Modifier = Modifier,
    indent: Float = 0.0f,
    backgroundIndicatorColor: Color = Color.LightGray.copy(alpha = 0.3f),
    gradientColors: List<Color> = listOf(
        Color(0xFF40c7e7),
        Color(0xFF6ce0c4),
        Color(0xFF40c7e7),
        Color(0xFF6ce0c4),
    )
) {
    Canvas(
        modifier = modifier
    ) {
        drawLine(
            color = backgroundIndicatorColor,
            cap = StrokeCap.Round,
            strokeWidth = size.height,
            start = Offset(x = 0f, y = 0f + size.height / 2),
            end = Offset(x = size.width, y = 0f + size.height / 2)
        )

        val start = indent * size.width
        val end = progress * size.width

        drawLine(
            brush = Brush.linearGradient(colors = gradientColors),
            cap = StrokeCap.Round,
            strokeWidth = size.height,
            start = Offset(x = start, y = 0f + size.height / 2),
            end = Offset(x = end, y = 0f + size.height / 2)
        )
    }
}