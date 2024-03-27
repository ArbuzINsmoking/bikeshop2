package com.example.bikeshop.domain.interactors

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.bikeshop.presentation.favouritesBike.ShoppingCartActivity

class NavigateToShoppingCartUseCase(private val mainActivity: Activity, private val shoppingCartActivity: ShoppingCartActivity) {
    fun execute() {
        val intent = Intent(mainActivity, shoppingCartActivity::class.java)
        startActivity(mainActivity, intent, null)
    }
}