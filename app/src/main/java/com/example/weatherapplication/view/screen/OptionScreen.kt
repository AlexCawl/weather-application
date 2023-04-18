package com.example.weatherapplication.view.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherapplication.view.layout.Screen
import com.example.weatherapplication.view.layout.WeatherBottomAppBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun OptionScreen(
    onNavigationItemSelected: (Screen) -> Unit
) {
    Scaffold(
        bottomBar = {
            WeatherBottomAppBar(onNavigationItemSelected = onNavigationItemSelected)
        }
    ) {
        Text(text = "Hello OptionScreen")
    }
}

@Preview
@Composable
fun PreviewOptionScreen() {

}