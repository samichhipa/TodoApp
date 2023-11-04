package com.app.todo.Domain.Repositories.SellItemUseCase

import com.app.todo.Domain.Repository.Repositories.SellItemRepository
import com.app.todo.models.response.Item

class AddItem(private val sellItem: SellItemRepository) {
    suspend operator fun invoke(items: List<Item>) {
        return sellItem.addSellItem(items)
    }
}