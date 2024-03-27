package com.example.bikeshop.data.model


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.bikeshop.data.model.Entity.BikeDBEntity

@Dao
interface BikeDao {
    @Insert(entity = BikeDBEntity::class)
    fun insertNewStatisticData(statistic: BikeDBEntity)

    @Query("SELECT bikeshop.id, bikeshop.info FROM bikeshop")
    fun getAllStatisticData(): List<BikeInfoTuple>

    @Query("DELETE FROM bikeshop WHERE id = :bikeId")
    fun deleteStatisticDataById(bikeId: Long)
}