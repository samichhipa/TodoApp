package com.app.todo.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.app.todo.R
import com.app.todo.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)


        binding.apply {
            callBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_callFragment)
            }
            buyBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_buyFragment)
            }
            sellBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_sellFragment)
            }
        }
        return binding.root
    }



}