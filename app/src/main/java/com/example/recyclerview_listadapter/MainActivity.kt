package com.example.recyclerview_listadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_listadapter.databinding.ActivityMainBinding
import com.example.recyclerview_listadapter.model.SampleData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapter = TestAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val addres = "https://run.mocky.io/v3/c3e88fdb-18f1-4a80-b546-be68720859db"

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitServices = retrofit.create(RetrofitServices::class.java)

        retrofitServices.getItemList().enqueue(object : Callback<SampleData> {
            override fun onResponse(call: Call<SampleData>, response: Response<SampleData>) {
                if (response.isSuccessful) {
                    val data = response.body()!!
                    Log.d("data","${data}")

                    adapter.submitList(data.items)
                }
            }
            override fun onFailure(call: Call<SampleData>, t: Throwable) {
                Log.d("error", "${t.message}")
            }

        })
    }
}









































