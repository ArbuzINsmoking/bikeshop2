package com.example.bikeshop.presentation.favouritesBike

import com.example.bikeshop.domain.model.PostModel

interface ShoppingCartContact {
    interface View {
        fun showPosts(posts: MutableList<PostModel>)
        fun showError(error: String)
        fun navigateToShoppingCart()
    }

    interface Presenter {
        fun loadPosts()
        fun onShopClicked()
    }
}