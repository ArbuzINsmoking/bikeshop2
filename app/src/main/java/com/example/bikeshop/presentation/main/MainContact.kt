package com.example.bikeshop.presentation.main;

import com.example.bikeshop.domain.model.PostModel

interface MainContact {
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