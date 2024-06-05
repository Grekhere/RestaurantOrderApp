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
import com.example.restaurantorderapp.adapter.DishAdapter
import com.example.restaurantorderapp.databinding.FragmentDishesBinding
import com.example.restaurantorderapp.viewmodel.DishViewModel
import com.example.restaurantorderapp.viewmodel.DishViewModelFactory

class DishesFragment : Fragment() {

    private lateinit var binding: FragmentDishesBinding
    private val viewModel: DishViewModel by viewModels { DishViewModelFactory() }
    private lateinit var adapter: DishAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDishesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DishAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        viewModel.getDishes().observe(viewLifecycleOwner, Observer { dishes ->
            adapter.submitList(dishes)
        })
    }
}
