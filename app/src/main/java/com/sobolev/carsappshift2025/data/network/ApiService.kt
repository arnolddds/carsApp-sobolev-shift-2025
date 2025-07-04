package com.sobolev.carsappshift2025.data.network

import com.sobolev.carsappshift2025.data.network.dto.CarsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("cars/info")
    suspend fun getAllCars(): CarsResponse

    @GET("cars/info/{carId}")
    suspend fun getCarById(
        @Path("carId") carId: String
    ): CarsResponse

}
