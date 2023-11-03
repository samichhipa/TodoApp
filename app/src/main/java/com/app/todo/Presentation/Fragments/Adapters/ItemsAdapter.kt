package com.app.todo.Presentation.Fragments.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.todo.Models.Response.Calls
import com.app.todo.Models.Response.Item
import com.app.todo.databinding.CallItemBinding
import com.app.todo.databinding.ItemBinding

class ItemsAdapter(
    var list: ArrayList<Item>? = arrayListOf(),
) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list!![position]

        holder.binding.model = data

    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }


}