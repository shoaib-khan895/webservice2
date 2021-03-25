package com.example.webservice.retrofit

import com.example.webservice.models.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    // Define end point
    @GET("v2/posts.json")
    fun getPosts(): Call<ResponseModel>
}
