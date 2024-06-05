package com.example.restaurantorderapp.model

data class OrderItem(
    val id: Int,
    val orderId: Int,
    val dishId: Int,
    val quantity: Int
)
