package com.sobolev.carsappshift2025.data.repository

import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.repository.CarsRepository
import kotlinx.coroutines.flow.Flow

class CarsRepositoryImpl : CarsRepository {
    override fun getAllCars(): Flow<List<Car>> {
        TODO("Not yet implemented")
    }

    override suspend fun getCar(carId: Int): Car {
        TODO("Not yet implemented")
    }
}