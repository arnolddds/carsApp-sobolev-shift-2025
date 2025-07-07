package com.sobolev.carsappshift2025.domain.repository

import com.sobolev.carsappshift2025.domain.entities.Car

interface CarsRepository {

    suspend fun getAllCars(): List<Car>


    suspend fun getCar(carId: Int): List<Car>

}