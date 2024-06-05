package com.example.restaurantorderapp.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantorderapp.databinding.ActivityLoginBinding
import com.example.restaurantorderapp.model.User
import com.example.restaurantorderapp.viewmodel.UserViewModel
import com.example.restaurantorderapp.viewmodel.UserViewModelFactory

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val viewModel: UserViewModel by viewModels { UserViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            val user = User(0, "username", email, "fullName")
            viewModel.login(user).observe(this, { response -> })
        }
    }
}