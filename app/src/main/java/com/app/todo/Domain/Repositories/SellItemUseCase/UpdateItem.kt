package com.app.todo.Domain.Repositories.SellItemUseCase

import com.app.todo.Domain.Repository.Repositories.SellItemRepository
import com.app.todo.Models.Response.Item

class UpdateItem(private val sellItem: SellItemRepository) {
    suspend operator fun invoke(item: Item) {
        return sellItem.removeItem(item)
    }
}