package com.sobolev.carsappshift2025.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sobolev.carsappshift2025.data.local.models.MediaDbModel

class Converters {

    @TypeConverter
    fun fromMediaList(mediaList: List<MediaDbModel>): String {
        return Gson().toJson(mediaList)
    }

    @TypeConverter
    fun toMediaList(data: String): List<MediaDbModel> {
        val listType = object : TypeToken<List<MediaDbModel>>() {}.type
        return Gson().fromJson(data, listType)
    }
}
