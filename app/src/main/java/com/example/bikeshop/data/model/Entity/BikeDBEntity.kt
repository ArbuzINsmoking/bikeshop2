package com.example.bikeshop.data.model.Entity

import androidx.room.*

@Entity(
    tableName = "bikeshop",
    indices = [Index("id")],
)

data class BikeDBEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val info: String
)