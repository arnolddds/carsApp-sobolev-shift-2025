package com.sobolev.carsappshift2025.domain.entities

data class Car(
    val id: Int,
    val name: String,
    val brand: String,
    val image: Media,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String
)