package com.sobolev.carsappshift2025.data.network

import com.sobolev.carsappshift2025.data.network.dto.CarsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("cars/info")
    suspend fun getAllCars(): Response<CarsResponse>
}
