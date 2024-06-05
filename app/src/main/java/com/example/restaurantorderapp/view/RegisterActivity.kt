package com.example.restaurantorderapp.view
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurantorderapp.databinding.ActivityRegisterBinding
import com.example.restaurantorderapp.model.User
import com.example.restaurantorderapp.viewmodel.UserViewModel
import com.example.restaurantorderapp.viewmodel.UserViewModelFactory

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: UserViewModel by viewModels { UserViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.registerButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val fullName = binding.fullNameEditText.text.toString()

            val user = User(0, "username", email, fullName)
            viewModel.register(user).observe(this, { response ->
                // Обработка ответа
            })
        }
    }
}