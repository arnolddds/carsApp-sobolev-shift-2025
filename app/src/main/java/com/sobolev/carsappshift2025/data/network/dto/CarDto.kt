package com.sobolev.carsappshift2025.data.network.dto

import com.google.gson.annotations.SerializedName

data class CarDto(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("media") val image: List<MediaDto>,
    @SerializedName("transmission") val transmission: String,
    @SerializedName("price") val price: Int,
    @SerializedName("location") val location: String,
    @SerializedName("color") val color: String,
    @SerializedName("bodyType") val bodyType: String,
    @SerializedName("steering") val steering: String
)
