package com.app.todo.Domain.Repositories.SellItemUseCase

import com.app.todo.Domain.Repository.Repositories.SellItemRepository
import com.app.todo.models.response.Item

class RemoveItem (private val sellItem: SellItemRepository) {
    suspend operator fun invoke() {
        return sellItem.removeAll()
    }
}