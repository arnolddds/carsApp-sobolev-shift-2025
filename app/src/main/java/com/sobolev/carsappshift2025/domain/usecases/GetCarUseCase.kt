package com.sobolev.carsappshift2025.domain.usecases

import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.repository.CarsRepository
import javax.inject.Inject

class GetCarUseCase @Inject constructor(
    private val repository: CarsRepository
) {

    suspend operator fun invoke(carId: Int): Car {
        return repository.getCar(carId)
    }
}