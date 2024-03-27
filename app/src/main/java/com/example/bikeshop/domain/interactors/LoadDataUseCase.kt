package com.example.bikeshop.domain.interactors

import android.content.Intent
import com.example.bikeshop.presentation.bikeshopDetail.BikeContract
import com.example.bikeshop.presentation.bikeshopDetail.BikeRepository


class LoadDataUseCase(private val view: BikeContract.View) {
    private val repository: BikeContract.Repository = BikeRepository()

     fun execute(intent: Intent) {
        val name = intent.getStringExtra("name")
        val color = intent.getStringExtra("color")
        val pic = intent.getStringExtra("pic")
        val price = intent.getStringExtra("price")

        view.showBikeDetails(name!!, color!!, pic!!, price!!)
    }
}