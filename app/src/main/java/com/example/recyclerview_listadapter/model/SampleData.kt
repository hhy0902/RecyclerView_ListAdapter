package com.example.recyclerview_listadapter.model


import com.google.gson.annotations.SerializedName

data class SampleData(
    @SerializedName("items")
    val items: List<Item>?
)