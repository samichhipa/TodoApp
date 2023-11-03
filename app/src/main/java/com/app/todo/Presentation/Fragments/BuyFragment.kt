package com.app.todo.Presentation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.todo.databinding.FragmentBuyBinding


class BuyFragment : Fragment() {


    lateinit var binding: FragmentBuyBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyBinding.inflate(layoutInflater)

        return binding.root
    }


}