package com.sobolev.carsappshift2025.data.network.dto

import com.google.gson.annotations.SerializedName

data class MediaDto(
    @SerializedName("url") val url: String,
    @SerializedName("isCover") val isCover: Boolean
)
