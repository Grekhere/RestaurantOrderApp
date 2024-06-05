package com.example.restaurantorderapp.network

import com.example.restaurantorderapp.model.User
import com.example.restaurantorderapp.model.Order
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.Call

interface ApiService {

    @POST("api/Auth/register")
    fun register(@Body user: User): Call<Void>

    @POST("api/Auth/login")
    fun login(@Body user: User): Call<Void>

    @GET("api/Orders/{userId}")
    fun getOrders(@Path("userId") userId: Int): Call<List<Order>>
}