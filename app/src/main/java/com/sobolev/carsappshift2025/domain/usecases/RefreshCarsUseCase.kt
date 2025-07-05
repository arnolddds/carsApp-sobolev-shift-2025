package com.sobolev.carsappshift2025.domain.usecases

import com.sobolev.carsappshift2025.domain.repository.CarsRepository
import javax.inject.Inject

class RefreshCarsUseCase @Inject constructor(
    private val repository: CarsRepository
) {
    suspend operator fun invoke() = repository.refreshCars()
}