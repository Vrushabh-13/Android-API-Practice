package com.example.a29api


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.a29api.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class UsersActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: UsersAdapter
    private val list = ArrayList<UserItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UsersAdapter(list)
        binding.recyclerView.adapter = adapter

        apiUserItem()


    }
    fun apiUserItem(){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        retrofit.getUsers().enqueue(object : Callback<ArrayList<UserItem>> {

            override fun onResponse(
                call: Call<ArrayList<UserItem>>,
                response: Response<ArrayList<UserItem>>
            ) {
                val data = response.body()
                if (data != null) {
                    list.clear()
                    list.addAll(data)
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<UserItem>>, t: Throwable) {
                Log.d("UsersActivity", "Error: ${t.message}")
            }
        })

    }
}