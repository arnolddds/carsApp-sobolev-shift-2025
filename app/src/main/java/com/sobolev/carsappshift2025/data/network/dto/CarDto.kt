package com.sobolev.carsappshift2025.data.network.dto

import com.google.gson.annotations.SerializedName
import com.sobolev.carsappshift2025.domain.entities.Media

data class CarDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("image") val image: Media,
    @SerializedName("transmission") val transmission: String,
    @SerializedName("price") val price: Int,
    @SerializedName("location") val location: String,
    @SerializedName("color") val color: String,
    @SerializedName("bodyType") val bodyType: String,
    @SerializedName("steering") val steering: String
)
