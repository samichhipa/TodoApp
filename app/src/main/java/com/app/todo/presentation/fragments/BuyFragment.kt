package com.app.todo.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.todo.MainActivity
import com.app.todo.ViewModels.BuySellItemViewModel
import com.app.todo.ViewModels.BuyViewModel
import com.app.todo.ViewModels.CallsViewModel
import com.app.todo.databinding.FragmentBuyBinding
import com.app.todo.databinding.FragmentCallBinding
import com.app.todo.models.Resource
import com.app.todo.models.response.Item
import com.app.todo.presentation.fragments.Adapters.CallsAdapter
import com.app.todo.presentation.fragments.Adapters.ItemsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BuyFragment : Fragment() {


    lateinit var binding: FragmentBuyBinding


    lateinit var adapter: ItemsAdapter
    var buyList = arrayListOf<Item>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuyBinding.inflate(layoutInflater)


        binding.apply {
            (requireActivity() as MainActivity).buySellVM?.let {
                it.idleBuy()
                it.onBuyRefresh()
                it.buy.observe(viewLifecycleOwner) {
                    when (it) {
                        is Resource.Empty -> {
                            binding.swipeToRefresh.isEnabled = true
                            buyList.clear()
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
                                buyList.clear()
                                buyList.addAll(it1.toMutableList())


                            } ?: {
                                binding.apply {
                                    rv.visibility = View.GONE
                                    progressIndicator.visibility = View.GONE
                                }
                            }

                        }
                    }
                }
            }

            swipeToRefresh.setOnRefreshListener {
                binding.swipeToRefresh.isRefreshing = false
                (requireActivity() as MainActivity).buySellVM?.let {
                    it.idleBuy()
                    it.onBuyRefresh()

                }
            }

            adapter = ItemsAdapter(buyList)

            rv.layoutManager = LinearLayoutManager(requireContext()).also {
                it.orientation = RecyclerView.VERTICAL
            }
            rv.adapter = adapter
            adapter.notifyDataSetChanged()


        }



        return binding.root
    }

    override fun onDestroyView() {
        (requireActivity() as MainActivity).buySellVM?.idleBuy()
        super.onDestroyView()
    }

}