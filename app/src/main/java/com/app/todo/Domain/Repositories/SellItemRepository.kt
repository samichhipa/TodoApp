package com.app.todo.Domain.Repository.Repositories

import androidx.lifecycle.LiveData
import com.app.todo.models.response.Item

interface SellItemRepository {


    suspend fun addSellItem(item: List<Item>)
    suspend fun getSellItems(): LiveData<List<Item>>

    suspend fun updateSellItem(item: Item)

    suspend fun removeAll()


}