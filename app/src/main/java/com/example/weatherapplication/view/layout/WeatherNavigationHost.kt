package com.example.weatherapplication.view.layout

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapplication.view.screen.OptionScreen
import com.example.weatherapplication.view.screen.SearchScreen
import com.example.weatherapplication.view.screen.WeatherScreen
import com.example.weatherapplication.view_model.LocationViewModel

@Composable
fun WeatherNavigationHost(
    locationManager: LocationViewModel,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.SEARCH.toString()
) {
    val router: (Screen) -> Unit = initRouter(navController)

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.WEATHER.toString()) {
            WeatherScreen(
                onNavigationItemSelected = router
            )
        }
        composable(Screen.SEARCH.toString()) {
            SearchScreen(
                locationManager = locationManager,
                onNavigationItemSelected = router,
            )
        }
        composable(Screen.OPTIONS.toString()) {
            OptionScreen(
                onNavigationItemSelected = router
            )
        }
    }
}

fun initRouter(navController: NavHostController): (Screen) -> Unit {
    return {
        when (it) {
            Screen.WEATHER -> navController.navigate(Screen.WEATHER.toString())
            Screen.SEARCH -> navController.navigate(Screen.SEARCH.toString())
            Screen.OPTIONS -> navController.navigate(Screen.OPTIONS.toString())
        }
    }
}

enum class Screen {
    WEATHER,
    SEARCH,
    OPTIONS
}