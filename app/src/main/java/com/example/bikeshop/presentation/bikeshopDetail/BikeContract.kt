package com.example.bikeshop.presentation.bikeshopDetail

import android.content.Intent

interface BikeContract {
    interface View {
        fun showBikeDetails(name: String, color: String, pic: String, price: String)
        fun navigateToCart()
    }

    interface Presenter {
        fun loadData(intent: Intent)
        fun onCartClicked()
    }

    interface Repository {

    }
}