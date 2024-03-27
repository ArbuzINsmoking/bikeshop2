package com.example.bikeshop.domain.interactors

import com.example.bikeshop.presentation.main.MainContact

class OnShopClickedUseCase(private val view: MainContact.View){
     fun execute() {
        view.navigateToShoppingCart()
    }
}