package com.example.bikeshop.presentation.bikeshopDetail

import android.content.Intent
import com.example.bikeshop.data.model.BikeRepository
import com.example.bikeshop.domain.interactors.LoadDataUseCase
import com.example.bikeshop.domain.interactors.OnCartClickedUseCase

class BikePresenter(private val view: BikeContract.View) : BikeContract.Presenter {
    private val repository: BikeContract.Repository = BikeRepository()
    val loadDataUseCase = LoadDataUseCase(view)
    val onCartClickedUseCase = OnCartClickedUseCase(view)

    override fun loadData(intent: Intent) {
        loadDataUseCase.execute(intent)
    }

    override fun onCartClicked() {
        onCartClickedUseCase.execute()
    }
}