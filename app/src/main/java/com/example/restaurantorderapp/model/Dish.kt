package com.example.restaurantorderapp.model

data class Dish(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String)