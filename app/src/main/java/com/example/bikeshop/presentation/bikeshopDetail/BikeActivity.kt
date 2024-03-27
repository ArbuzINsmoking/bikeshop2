package com.example.bikeshop.presentation.bikeshopDetail

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.example.bikeshop.R
import com.example.bikeshop.data.model.Dependencies
import com.example.bikeshop.data.model.Entity.BikeDBEntity
import com.example.bikeshop.domain.interactors.NavigateToShoppingCartUseCase
import com.example.bikeshop.domain.interactors.ShowBikeDetailsUseCase
import com.example.bikeshop.presentation.favouritesBike.ShoppingCartActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class ZooActivity() : ComponentActivity(), BikeContract.View, CoroutineScope {
    private lateinit var presenter: BikeContract.Presenter
    private lateinit var bikeName: TextView
    private lateinit var bikeColor: TextView
    private lateinit var bikePrice: TextView
    private lateinit var bikePic: ImageView
    private val viewModel by lazy { (Dependencies.bikeRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bikeshop)
        presenter = BikePresenter(this)
        bikeName = findViewById(R.id.bikeName)
        bikeColor = findViewById(R.id.bikeColor)
        bikePrice = findViewById(R.id.bikePrice)
        bikePic = findViewById(R.id.imageView)

        Dependencies.init(applicationContext)

        val imageShop = findViewById<ImageView>(R.id.imageShop)
        imageShop.setOnClickListener {
            presenter.onCartClicked()
        }

        presenter.loadData(intent)
    }

    override fun showBikeDetails(name: String, color: String, pic: String, price: String) {
        val showBikeDetailsUseCase = ShowBikeDetailsUseCase(BikePresenter(this),bikeName,bikeColor,bikePrice,bikePic)
        showBikeDetailsUseCase.execute(name, color, pic, price)

        val shopCart = findViewById<Button>(R.id.shopButton)
        shopCart.setOnClickListener {
            lifecycleScope.launch {
                val a = BikeDBEntity(1, name)
                viewModel.insertNewBikeData(a)
            }
        }
    }

    override fun navigateToCart() {
        var navigateToShoppingCartUseCase = NavigateToShoppingCartUseCase(this, ShoppingCartActivity())
        navigateToShoppingCartUseCase.execute()
    }

    override val coroutineContext: CoroutineContext
        get() = TODO("Not yet implemented")
}



class BikeRepository : BikeContract.Repository {

}
