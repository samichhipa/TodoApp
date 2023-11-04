package com.app.todo.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.todo.presentation.activity.MainActivity
import com.app.todo.databinding.FragmentSellBinding
import com.app.todo.models.response.Item
import com.app.todo.presentation.fragments.Adapters.ItemsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SellFragment : Fragment() {

    lateinit var binding: FragmentSellBinding
    lateinit var adapter: ItemsAdapter
    var sellList = arrayListOf<Item>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSellBinding.inflate(layoutInflater)
        binding.swipeToRefresh.setOnRefreshListener {
            binding.swipeToRefresh.isRefreshing = false
            (requireActivity() as MainActivity).buySellVM?.let {

                it.onSellRefresh()

            }
        }

        (requireActivity() as MainActivity).buySellVM?.let {
            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    it.getSellItems().observe(viewLifecycleOwner) {
                        sellList.clear()
                        sellList.addAll(it)
                        adapter.notifyDataSetChanged()
                    }
                }
            }


        }

        adapter = ItemsAdapter(sellList)

        binding.rv.layoutManager = LinearLayoutManager(requireContext()).also {
            it.orientation = RecyclerView.VERTICAL
        }
        binding.rv.adapter = adapter
        adapter.notifyDataSetChanged()

        return binding.root
    }

}