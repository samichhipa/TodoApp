package com.app.todo.Domain.Repositories.SellItemUseCase

import com.app.todo.Domain.Repository.Repositories.SellItemRepository
import com.app.todo.Models.Response.Item

class AddItem(private val sellItem: SellItemRepository) {
    suspend operator fun invoke(item: Item) {
        return sellItem.addSellItem(item)
    }
}