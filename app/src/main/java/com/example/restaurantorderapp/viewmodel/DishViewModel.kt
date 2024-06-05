package com.example.restaurantorderapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.restaurantorderapp.model.Dish
import com.example.restaurantorderapp.repository.DishRepository
import kotlinx.coroutines.Dispatchers

class DishViewModel(private val repository: DishRepository) : ViewModel() {

    fun getDishes() = liveData(Dispatchers.IO) {
        val response = repository.getDishes()
        emit(response)
    }

    fun addDishToCart(dish: Dish) = liveData(Dispatchers.IO) {
        repository.addDishToCart(dish)
        emit(true)
    }
}