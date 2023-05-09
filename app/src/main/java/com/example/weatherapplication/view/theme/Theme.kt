package com.example.weatherapplication.view.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = DeepBlue,
    primaryVariant = DeepBlue,
    secondary = DeepBlue,
    secondaryVariant = DeepBlue,
    background = DarkGray,
    surface = DarkBlue,
    error = Color.Red,
    onPrimary = BaseWhite,
    onSecondary = BaseWhite,
    onBackground = LightGray,
    onSurface = LightGray,
    onError = BaseWhite,
)

private val LightColorPalette = lightColors(
    primary = DeepBlue,
    primaryVariant = DeepBlue,
    secondary = DeepBlue,
    secondaryVariant = DeepBlue,
    background = DarkGray,
    surface = DarkBlue,
    error = Color.Red,
    onPrimary = BaseWhite,
    onSecondary = BaseWhite,
    onBackground = BaseWhite,
    onSurface = LightGray,
    onError = BaseWhite,
)

@Composable
fun WeatherApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}