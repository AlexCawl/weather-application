package com.example.weatherapplication.ui.screen

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapplication.model.service.ConverterService
import com.example.weatherapplication.vm.LocationViewModel
import com.example.weatherapplication.vm.WeatherViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalMaterialApi::class, ExperimentalPagerApi::class)
@Composable
fun MainScreen(
    weatherViewModel: WeatherViewModel,
    locationViewModel: LocationViewModel,
    converter: ConverterService
) {
    val navigationController: NavHostController = rememberNavController()

    NavHost(
        modifier = Modifier,
        navController = navigationController,
        startDestination = "weather"
    ) {
        composable("weather") {
            WeatherScreen(
                viewModel = weatherViewModel,
                onClickRefreshEvent = { /*TODO*/ },
                onClickOptionsEvent = {
                    navigationController.navigate("location") {
                        launchSingleTop = true
                    }
                },
                converter = converter
            )
        }
        composable("location") {
            LocationScreen(
                viewModel = weatherViewModel,
                onClickReturnEvent = {
                    navigationController.navigate("weather") {
                        launchSingleTop = true
                    }
                },
                onClickRefreshEvent = { /*TODO*/ },
                onClickSettingsEvent = {
                    navigationController.navigate("settings") {
                        launchSingleTop = true
                    }
                },
                onClickAddEvent = {
                    navigationController.navigate("search") {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable("search") {
            SearchScreen(
                viewModel = locationViewModel,
                onClickReturnEvent = {
                    navigationController.navigate("location") {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable("settings") {
            SettingsScreen(

            )
        }
    }
}