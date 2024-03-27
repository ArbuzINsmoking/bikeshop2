package com.example.bikeshop.domain.interactors

import android.widget.ImageView
import android.widget.TextView
import com.example.bikeshop.presentation.bikeshopDetail.BikePresenter
import com.squareup.picasso.Picasso

class ShowBikeDetailsUseCase(private val presenter: BikePresenter, private val zooName:TextView,
                             private  var zooColor: TextView, private  var zooPrice: TextView,
                             private  var zooPic: ImageView
) {

     fun execute(name: String, color: String, pic: String, price: String) {
        zooName.text = name
        zooColor.text = "Цвет: $color"
        zooPrice.text = "Цена: $price"

        Picasso.get()
            .load(pic)
            .into(zooPic)
    }

}