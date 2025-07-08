package com.sobolev.carsappshift2025.data.network.dto

import com.google.gson.annotations.SerializedName


data class CarResponse(
    @SerializedName("data") val car: CarDto
)