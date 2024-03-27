package com.example.bikeshop.data.model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bikeshop.data.model.Entity.BikeDBEntity

@Database(
    version = 1,
    entities = [
        BikeDBEntity::class
    ]
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun getbikeDao(): BikeDao
}