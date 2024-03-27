package com.example.bikeshop.presentation.favouritesBike

import com.example.bikeshop.data.API.ApiInterface
import com.example.bikeshop.domain.interactors.FavoriteShoppingBikeUseCase
import com.example.bikeshop.domain.interactors.LoadShoppingZooUseCase

class ShoppingCartPresenter(private val view: ShoppingCartContact.View, private val apiInterface: ApiInterface) :
    ShoppingCartContact.Presenter {
    var loadShoppingZooUseCase = LoadShoppingZooUseCase(view, apiInterface)
    var favoriteShoppingBikeUseCase = FavoriteShoppingBikeUseCase(view)

    override fun loadPosts() {
        loadShoppingZooUseCase.execute()
    }

    override fun onShopClicked() {
        favoriteShoppingBikeUseCase.execute()
    }
}