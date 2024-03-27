package com.example.bikeshop.domain.interactors

import com.example.bikeshop.presentation.favouritesBike.ShoppingCartContact

class FavoriteShoppingBikeUseCase(private val view: ShoppingCartContact.View){
    fun execute() {
        view.navigateToShoppingCart()
    }
}