package com.example.restaurantorderapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.restaurantorderapp.model.User
import com.example.restaurantorderapp.network.RetrofitInstance
import kotlinx.coroutines.Dispatchers

class UserViewModel : ViewModel() {
    fun register(user: User) = liveData(Dispatchers.IO) {
        val response = RetrofitInstance.api.register(user)
        emit(response)
    }

    fun login(user: User) = liveData(Dispatchers.IO) {
        val response = RetrofitInstance.api.login(user)
        emit(response)
    }
}