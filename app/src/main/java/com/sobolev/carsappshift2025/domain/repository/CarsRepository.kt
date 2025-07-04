package com.sobolev.carsappshift2025.domain.repository

import com.sobolev.carsappshift2025.domain.entities.Car
import kotlinx.coroutines.flow.Flow

interface CarsRepository {

    fun getAllCars(): Flow<List<Car>>


    suspend fun getCar(carId: Int): Car

    suspend fun refreshCars()
}