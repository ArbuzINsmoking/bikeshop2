package com.example.bikeshop.domain.interactors

import com.example.bikeshop.presentation.bikeshopDetail.BikeContract

class OnCartClickedUseCase(private val view: BikeContract.View) {
     fun execute() {
        view.navigateToCart()
    }
}