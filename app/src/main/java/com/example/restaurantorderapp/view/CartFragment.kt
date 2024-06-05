package com.example.restaurantorderapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restaurantorderapp.R
import com.example.restaurantorderapp.adapter.CartAdapter
import com.example.restaurantorderapp.databinding.FragmentCartBinding
import com.example.restaurantorderapp.viewmodel.CartViewModel
import com.example.restaurantorderapp.viewmodel.CartViewModelFactory

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private val viewModel: CartViewModel by viewModels { CartViewModelFactory() }
    private lateinit var adapter: CartAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CartAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.getCartItems().observe(viewLifecycleOwner, Observer { items ->
            adapter.submitList(items)
        })

        binding.checkoutButton.setOnClickListener {
            viewModel.checkout()
        }
    }
}
