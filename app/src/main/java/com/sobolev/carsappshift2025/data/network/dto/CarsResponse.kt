package com.sobolev.carsappshift2025.data.network.dto

import com.google.gson.annotations.SerializedName


data class CarsResponse(
    @SerializedName("data") val cars: List<CarDto>
)