package com.example.a29api

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a29api.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import CommentsAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CommentsAdapter
    private val list = ArrayList<MyCommentsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CommentsAdapter(list)
        binding.recyclerView.adapter = adapter


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getComments()

        retrofitData.enqueue(object : Callback<ArrayList<MyCommentsItem>> {

            override fun onResponse(
                call: Call<ArrayList<MyCommentsItem>>,
                response: Response<ArrayList<MyCommentsItem>>
            ) {
                val responseBody = response.body()

                if (responseBody != null) {
                    list.clear()
                    list.addAll(responseBody)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<MyCommentsItem>>, t: Throwable) {
                Log.d("MainActivity", "onFailure: ${t.message}")
            }
        })
    }
}