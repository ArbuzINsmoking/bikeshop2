package com.example.bikeshop.presentation.main;

import com.example.bikeshop.data.API.ApiInterface
import com.example.bikeshop.domain.interactors.LoadPostsUseCase
import com.example.bikeshop.domain.interactors.OnShopClickedUseCase


class MainPresent(private val view: MainContact.View, private val apiInterface: ApiInterface) :
        MainContact.Presenter {
        var loadPostsUseCase = LoadPostsUseCase(view, apiInterface)
        var onShopClickedUseCase = OnShopClickedUseCase(view)

        override fun loadPosts() {
                loadPostsUseCase.execute()
        }

        override fun onShopClicked() {
                onShopClickedUseCase.execute()
        }

}
