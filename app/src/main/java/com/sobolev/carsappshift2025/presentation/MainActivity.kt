package com.sobolev.carsappshift2025.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.sobolev.carsappshift2025.presentation.ui.screens.cars.CarsScreen
import com.sobolev.carsappshift2025.presentation.ui.theme.CarsAppShift2025Theme
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