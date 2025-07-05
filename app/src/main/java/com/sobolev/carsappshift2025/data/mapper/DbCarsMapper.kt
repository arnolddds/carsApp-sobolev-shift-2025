package com.sobolev.carsappshift2025.data.mapper

import com.sobolev.carsappshift2025.data.local.models.CarDbModel
import com.sobolev.carsappshift2025.data.local.models.MediaDbModel
import com.sobolev.carsappshift2025.domain.entities.Car
import com.sobolev.carsappshift2025.domain.entities.Media

fun CarDbModel.toDomain(): Car {
    return Car(
        id = id,
        name = name,
        brand = brand,
        image = media.map { it.toDomain() },
        transmission = transmission,
        price = price,
        location = location,
        color = color,
        bodyType = bodyType,
        steering = steering
    )
}

fun MediaDbModel.toDomain(): Media {
    return Media(
        url = url,
        isCover = isCover
    )
}


