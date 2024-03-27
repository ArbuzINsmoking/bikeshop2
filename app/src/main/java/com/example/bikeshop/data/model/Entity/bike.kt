package com.example.bikeshop.data.model.Entity


data class bike(
    val info: String
) {

    fun toBikeDbEntity(): BikeDBEntity = BikeDBEntity(
        id = 0,
        info = info
    )
}