package com.example.bikeshop.presentation.favouritesBike

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeshop.R
import com.example.bikeshop.data.model.Dependencies
import kotlinx.coroutines.launch

class ShoppingCartActivity : AppCompatActivity() {
    private val viewModel by lazy { (Dependencies.bikeRepository) }
    private var recyclerView = findViewById<RecyclerView>(R.id.recycleView)

    override  fun onCreate(savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            aboba()
        }
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)

    }

    suspend fun aboba() {
        viewModel.getAllBikeData()
    }

}