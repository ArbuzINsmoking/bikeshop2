package com.example.bikeshop.presentation.main

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeshop.data.API.ApiInterface
import com.example.bikeshop.data.API.ServiceGenerator
import com.example.bikeshop.domain.interactors.NavigateToShoppingCartUseCase
import com.example.bikeshop.domain.interactors.ShowErrorUseCase
import com.example.bikeshop.domain.interactors.ShowPostsUseCase
import com.example.bikeshop.domain.model.PostModel
import com.example.bikeshop.presentation.favouritesBike.ShoppingCartActivity
import com.example.bikeshop.R

class MainActivity : AppCompatActivity(), MainContact.View {
    private lateinit var mytoolBar: Toolbar
    private lateinit var presenter: MainContact.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mytoolBar = findViewById(R.id.toolBar)
        setSupportActionBar(mytoolBar)

        val imageShop = findViewById<ImageView>(R.id.imageShop)
        imageShop.setOnClickListener {
            presenter.onShopClicked()
        }
        presenter = MainPresent(this, ServiceGenerator.buildService(ApiInterface::class.java))
        presenter.loadPosts()
    }


    override fun showPosts(posts: MutableList<PostModel>) {
        val rec = findViewById<RecyclerView>(R.id.recycleView)
        var main = this
        val showPostsUseCase = ShowPostsUseCase(posts, rec, main)
        showPostsUseCase.execute()
    }

    override fun showError(error: String) {
        val showErrorUseCase = ShowErrorUseCase(error)
        showErrorUseCase.execute()
    }

    override fun navigateToShoppingCart() {
        var navigateToShoppingCartUseCase = NavigateToShoppingCartUseCase(this, ShoppingCartActivity())
        navigateToShoppingCartUseCase.execute()
    }
}