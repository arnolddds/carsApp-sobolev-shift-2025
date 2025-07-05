package com.sobolev.carsappshift2025.data.mapper

import com.sobolev.carsappshift2025.data.local.models.CarDbModel
import com.sobolev.carsappshift2025.data.local.models.MediaDbModel
import com.sobolev.carsappshift2025.data.network.dto.CarDto
import com.sobolev.carsappshift2025.data.network.dto.MediaDto


fun CarDto.toDbModel(): CarDbModel {
    return CarDbModel(
        id = id,
        name = name,
        brand = brand,
        media = image.map { it.toDbModel() },
        transmission = transmission,
        price = price,
        location = location,
        color = color,
        bodyType = bodyType,
        steering = steering
    )
}

fun MediaDto.toDbModel(): MediaDbModel {
    return MediaDbModel(
        url = url,
        isCover = isCover
    )
}



