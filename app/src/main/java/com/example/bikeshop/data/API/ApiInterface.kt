package com.example.bikeshop.data.API

import com.example.bikeshop.domain.model.PostModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/bikeshop")
    fun getPosts() :Call<MutableList<PostModel>>
}