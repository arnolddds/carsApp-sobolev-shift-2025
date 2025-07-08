package com.sobolev.carsappshift2025.presentation.navigation

import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.sobolev.carsappshift2025.presentation.ui.screens.cars.CarsScreen
import com.sobolev.carsappshift2025.presentation.ui.screens.details.CarDetailsScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Cars.route
    ) {
        composable(Screen.Cars.route) {
            CarsScreen(
                onCarClick = { car ->
                    navController.navigate(Screen.CarInfo.createRoute(car.id))
                }
            )
        }

        composable(
            route = Screen.CarInfo.route,
            arguments = listOf(navArgument("car_id") { type = NavType.StringType })
        ) { backStackEntry ->
            val carId = backStackEntry.arguments?.getString("car_id") ?: ""
            CarDetailsScreen(
                carId = carId,
                onBackClick = { navController.popBackStack() },
                onBookClick = {}
            )
        }
    }
}


sealed class Screen(val route: String) {

    data object Cars : Screen("cars")

    data object CarInfo : Screen("car_info/{car_id}") {
        fun createRoute(userId: String) = "car_info/$userId"
    }
}