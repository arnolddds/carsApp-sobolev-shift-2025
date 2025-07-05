package com.sobolev.carsappshift2025.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.entities.Media
import com.sobolev.carsappshift2025.presentation.screens.cars.CarsScreen
import com.sobolev.carsappshift2025.presentation.theme.ui.CarsAppShift2025Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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

                    }

                )
            }
        }
    }
}