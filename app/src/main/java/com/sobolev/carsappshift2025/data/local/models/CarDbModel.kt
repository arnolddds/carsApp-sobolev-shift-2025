package com.sobolev.carsappshift2025.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class CarDbModel(
    @PrimaryKey val id: Int,
    val name: String,
    val brand: String,
    val media: List<MediaDbModel>,
    val transmission: String,
    val price: Int,
    val location: String,
    val color: String,
    val bodyType: String,
    val steering: String
)