package com.sobolev.carsappshift2025.data.repository

import com.sobolev.carsappshift2025.data.local.db.CarsDao
import com.sobolev.carsappshift2025.data.local.models.CarDbModel
import com.sobolev.carsappshift2025.data.mapper.toDomain
import com.sobolev.carsappshift2025.data.network.ApiService
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.repository.CarsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val carsDao: CarsDao
) : CarsRepository {
    override fun getAllCars(): Flow<List<Car>> {
        return carsDao.getAllCars()
            .map { list: List<CarDbModel> -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun getCar(carId: Int): Car {
        return carsDao.getCar(carId).toDomain()
    }
}