package com.sobolev.carsappshift2025.di

import android.content.Context
import androidx.room.Room
import com.sobolev.carsappshift2025.data.local.db.CarsDao
import com.sobolev.carsappshift2025.data.local.db.CarsDataBase
import com.sobolev.carsappshift2025.data.repository.CarsRepositoryImpl
import com.sobolev.carsappshift2025.domain.repository.CarsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindUsersRepository(
        impl: CarsRepositoryImpl
    ): CarsRepository


    companion object {

        @Singleton
        @Provides
        fun provideDataBase(
            @ApplicationContext context: Context
        ): CarsDataBase {
            return Room.databaseBuilder(
                context = context,
                klass = CarsDataBase::class.java,
                name = "cars.db"
            ).build()
        }

        @Singleton
        @Provides
        fun provideUsersDao(
            dataBase: CarsDataBase
        ): CarsDao {
            return dataBase.carsDao()
        }
    }
}