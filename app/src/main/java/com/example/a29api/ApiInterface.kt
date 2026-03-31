package com.example.a29api
import retrofit2.Call
import retrofit2.http.GET


interface ApiInterface {

    @GET("comments")
    fun getComments() : Call<ArrayList<MyCommentsItem>>

    @GET("users")
    fun getUsers(): Call<ArrayList<UserItem>>

}