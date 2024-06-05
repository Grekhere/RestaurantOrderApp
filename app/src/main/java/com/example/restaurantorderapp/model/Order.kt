package com.example.restaurantorderapp.model

data class Order(
    val id: Int,
    val dish: String,
    val quantity: Int,
    val userId: Int
)
