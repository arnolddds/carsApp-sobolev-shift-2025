package com.sobolev.carsappshift2025.domain.usecases

import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.repository.CarsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAllCarsUseCase @Inject constructor(
    private val repository: CarsRepository
) {

    suspend operator fun invoke(): List<Car> = repository.getAllCars()
}