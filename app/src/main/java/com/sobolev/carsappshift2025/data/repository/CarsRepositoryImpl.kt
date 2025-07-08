package com.sobolev.carsappshift2025.data.repository

import com.sobolev.carsappshift2025.data.mapper.toDomain
import com.sobolev.carsappshift2025.data.network.ApiService
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.repository.CarsRepository
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : CarsRepository {

    override suspend fun getAllCars(): List<Car> {
        return apiService.getAllCars().cars.map { it.toDomain() }
    }

    override suspend fun getCar(carId: String): Car {
        return apiService.getCarById(carId).car.toDomain()
    }

}