package com.app.todo.Presentation.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.app.todo.Models.Resource
import com.app.todo.ViewModels.CallsViewModel
import com.app.todo.databinding.FragmentCallBinding
import kotlinx.coroutines.launch


class CallFragment : Fragment() {


    lateinit var binding: FragmentCallBinding
    private val callVM: CallsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCallBinding.inflate(layoutInflater)

        callVM.call.observe(viewLifecycleOwner) {

            when (it) {
                is Resource.Empty -> {

                }

                is Resource.Error -> {
                    com.app.todo.error(binding.root, it.message ?: "")
                }

                is Resource.Loading -> {

                }

                is Resource.Success -> {

                }
            }
        }


        return binding.root
    }

    override fun onDestroyView() {
        callVM.Idle()
        super.onDestroyView()
    }
}