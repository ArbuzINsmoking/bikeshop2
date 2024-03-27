package com.example.bikeshop.data.model


import com.example.bikeshop.data.model.Entity.BikeDBEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BikeRepository(private val bikeDao: BikeDao) {
    suspend fun insertNewBikeData(bikeDBEntity: BikeDBEntity) {
        withContext(Dispatchers.IO) {
            bikeDao.insertNewStatisticData(bikeDBEntity)
        }
    }

    suspend fun getAllBikeData(): List<BikeInfoTuple> {
        return withContext(Dispatchers.IO) {
            return@withContext bikeDao.getAllStatisticData()
        }
    }

    suspend fun removeBikeDataById(id: Long) {
        withContext(Dispatchers.IO) {
            bikeDao.deleteStatisticDataById(id)
        }
    }
}