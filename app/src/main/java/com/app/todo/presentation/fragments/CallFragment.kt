package com.app.todo.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.app.todo.models.Resource
import com.app.todo.ViewModels.CallsViewModel
import com.app.todo.databinding.FragmentCallBinding
import com.app.todo.presentation.fragments.Adapters.CallsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CallFragment : Fragment() {


    lateinit var binding: FragmentCallBinding
    private var callVM: CallsViewModel? = null
    lateinit var adapter: CallsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCallBinding.inflate(layoutInflater)

        callVM = ViewModelProvider(this)[CallsViewModel::class.java]
        binding.apply {


            swipeToRefresh.setOnRefreshListener {
                binding.swipeToRefresh.isRefreshing = false
                callVM?.getCalls()
            }

            adapter = CallsAdapter(arrayListOf())

            rv.layoutManager = LinearLayoutManager(requireContext()).also {
                it.orientation = VERTICAL
            }
            rv.adapter = adapter
            adapter.notifyDataSetChanged()
        }


        callVM?.call?.observe(viewLifecycleOwner) {

            when (it) {
                is Resource.Empty -> {
                    binding.swipeToRefresh.isEnabled = true
                }

                is Resource.Error -> {
                    binding.apply {
                        rv.visibility = View.GONE
                        progressIndicator.visibility = View.GONE
                    }
                    binding.swipeToRefresh.isEnabled = true
                    com.app.todo.error(binding.root, it.message ?: "")
                }

                is Resource.Loading -> {

                    binding.apply {
                        swipeToRefresh.isEnabled = false
                        rv.visibility = View.GONE
                        progressIndicator.visibility = View.VISIBLE
                    }
                }

                is Resource.Success -> {


                    binding.swipeToRefresh.isEnabled = true



                    it.data?.toMutableList()?.let { it1 ->
                        binding.apply {
                            rv.visibility = View.VISIBLE
                            progressIndicator.visibility = View.GONE
                        }
                        adapter.list?.clear()
                        adapter.list?.addAll(it1)
                        adapter.notifyDataSetChanged()
                    } ?: {
                        binding.apply {
                            rv.visibility = View.GONE
                            progressIndicator.visibility = View.GONE
                        }
                    }

                }
            }
        }


        return binding.root
    }

    override fun onDestroyView() {
        callVM?.Idle()
        super.onDestroyView()
    }
}