package com.example.webservice.models

import com.google.gson.annotations.SerializedName

data class DataModel(
    @SerializedName("name")
    val postName: String,
    @SerializedName("message")
    val postMessage: String,
    @SerializedName("profileImage")
    val postProfileImgURL: String
)