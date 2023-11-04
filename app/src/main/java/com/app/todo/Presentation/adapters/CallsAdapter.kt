package com.app.todo.presentation.fragments.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.todo.BR
import com.app.todo.models.response.Calls
import com.app.todo.databinding.CallItemBinding

class CallsAdapter(
    var list: ArrayList<Calls>? = arrayListOf(),
) : RecyclerView.Adapter<CallsAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CallItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            CallItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list!![position]

        holder.binding.setVariable(BR.call,data)

    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }


}