package com.example.restaurantorderapp.repository

import com.example.restaurantorderapp.model.Dish
import com.example.restaurantorderapp.network.ApiService

class DishRepository(private val apiService: ApiService) {

    suspend fun getDishes() = apiService.getDishes()
    suspend fun addDishToCart(dish: Dish) {
        // Add dish to local cart (shared preferences or local database)
    }
}
