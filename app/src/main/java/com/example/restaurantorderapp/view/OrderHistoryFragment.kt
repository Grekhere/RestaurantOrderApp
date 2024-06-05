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
import com.example.restaurantorderapp.adapter.OrderAdapter
import com.example.restaurantorderapp.databinding.FragmentOrderHistoryBinding
import com.example.restaurantorderapp.viewmodel.OrderViewModel
import com.example.restaurantorderapp.viewmodel.OrderViewModelFactory

class OrderHistoryFragment : Fragment() {

    private lateinit var binding: FragmentOrderHistoryBinding
    private val viewModel: OrderViewModel by viewModels { OrderViewModelFactory() }
    private lateinit var adapter: OrderAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOrderHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = OrderAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.getOrders().observe(viewLifecycleOwner, Observer { orders ->
            adapter.submitList(orders)
        })
    }
}