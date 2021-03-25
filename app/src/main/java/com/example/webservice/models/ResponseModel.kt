package com.example.webservice.models

import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("posts")
    val posts: ArrayList<DataModel>
)