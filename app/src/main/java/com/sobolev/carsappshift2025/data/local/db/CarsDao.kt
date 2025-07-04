package com.sobolev.carsappshift2025.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sobolev.carsappshift2025.data.local.models.CarDbModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CarsDao {

    @Query("SELECT * FROM cars")
    fun getAllCars(): Flow<List<CarDbModel>>

    @Query("SELECT * FROM cars WHERE id = :carId")
    suspend fun getCar(carId: Int): CarDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(cars: List<CarDbModel>)

    @Query("DELETE FROM cars")
    suspend fun clearAll()

}

