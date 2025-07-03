package com.sobolev.carsappshift2025.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.entities.Media
import com.sobolev.carsappshift2025.presentation.screens.cars.CarsScreen
import com.sobolev.carsappshift2025.presentation.theme.ui.CarsAppShift2025Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val cars = mutableListOf<Car>().apply {
            for (i in 1..10) {
                add(Car(
                    id = i,
                    name = "Model $i",
                    brand = when (i % 3) {
                        0 -> "Toyota"
                        1 -> "BMW"
                        else -> "Mercedes"
                    },
                    image = Media(
                        url = "url",
                        isCover = i == 1
                    ),
                    transmission = when (i % 2) {
                        0 -> "Automatic"
                        else -> "Manual"
                    },
                    price = 20000 + i * 5000,
                    location = when (i % 4) {
                        0 -> "New York"
                        1 -> "Los Angeles"
                        2 -> "Chicago"
                        else -> "Miami"
                    },
                    color = when (i % 5) {
                        0 -> "Red"
                        1 -> "Blue"
                        2 -> "Black"
                        3 -> "White"
                        else -> "Silver"
                    },
                    bodyType = when (i % 3) {
                        0 -> "Sedan"
                        1 -> "SUV"
                        else -> "Coupe"
                    },
                    steering = when (i % 2) {
                        0 -> "Left"
                        else -> "Right"
                    }
                ))
            }
        }
        setContent {
            CarsAppShift2025Theme {
                CarsScreen(
                    onCarClick = {

                    },
                    onButtonClick = {

                    },
                    onQueryChange = {

                    },
                    onCalendarClick = {

                    },
                    cars = cars

                )
            }
        }
    }
}