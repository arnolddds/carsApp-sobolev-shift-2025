package com.sobolev.carsappshift2025.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sobolev.carsappshift2025.data.local.models.CarDbModel

@Database(
    entities = [CarDbModel::class],
    version = 1,
    exportSchema = false
)
abstract class CarsDataBase : RoomDatabase() {

    abstract fun carsDao(): CarsDao

}