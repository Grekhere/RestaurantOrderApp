package com.example.restaurantorderapp.repository

import com.example.restaurantorderapp.model.User
import com.example.restaurantorderapp.model.Order
import com.example.restaurantorderapp.network.RetrofitInstance
import retrofit2.Call

class Repository {

    fun register(user: User): Call<Void> {
        return RetrofitInstance.api.register(user)
    }

    fun login(user: User): Call<Void> {
        return RetrofitInstance.api.login(user)
    }

    fun getOrders(userId: Int): Call<List<Order>> {
        return RetrofitInstance.api.getOrders(userId)
    }
}