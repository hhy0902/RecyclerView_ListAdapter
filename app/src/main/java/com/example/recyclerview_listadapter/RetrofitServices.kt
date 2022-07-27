package com.example.recyclerview_listadapter

import com.example.recyclerview_listadapter.model.SampleData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("/v3/c3e88fdb-18f1-4a80-b546-be68720859db")
    fun getItemList(
    ) : Call<SampleData>
}