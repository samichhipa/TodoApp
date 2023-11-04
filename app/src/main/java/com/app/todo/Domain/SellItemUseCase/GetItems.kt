package com.app.todo.Domain.Repositories.SellItemUseCase

import androidx.lifecycle.LiveData
import com.app.todo.Domain.Repository.Repositories.SellItemRepository
import com.app.todo.models.response.Item

class GetItems(private val sellItem: SellItemRepository) {
    suspend operator fun invoke(): LiveData<List<Item>> {
        return sellItem.getSellItems()
    }
}