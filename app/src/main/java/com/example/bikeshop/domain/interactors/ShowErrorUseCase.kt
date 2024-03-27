package com.example.bikeshop.domain.interactors

import android.util.Log

class ShowErrorUseCase(private val error: String) {
    fun execute() {
        Log.e("error", error)
    }
}