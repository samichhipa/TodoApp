package com.app.todo.Domain.Repository.Repositories

import androidx.lifecycle.LiveData
import com.app.todo.Models.Resource
import com.app.todo.Models.Response.Item

interface SellItemRepository {


    suspend fun addSellItem(item: Item)
    suspend fun getSellItems(): LiveData<List<Item>>

    suspend fun updateSellItem(item: Item)

    suspend fun removeItem(item: Item)


}