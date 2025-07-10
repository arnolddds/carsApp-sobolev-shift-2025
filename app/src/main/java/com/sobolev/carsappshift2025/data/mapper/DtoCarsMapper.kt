package com.sobolev.carsappshift2025.data.mapper

import com.sobolev.carsappshift2025.data.network.dto.CarDto
import com.sobolev.carsappshift2025.data.network.dto.MediaDto
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.entities.Media


fun CarDto.toDomain(): Car {
    return Car(
        id = id,
        name = name,
        brand = brand,
        media = image.map { it.toDomain() },
        transmission = transmission,
        price = price,
        location = location,
        color = color,
        bodyType = bodyType,
        steering = steering
    )
}

fun MediaDto.toDomain(): Media {
    return Media(
        url = url,
        isCover = isCover
    )
}



