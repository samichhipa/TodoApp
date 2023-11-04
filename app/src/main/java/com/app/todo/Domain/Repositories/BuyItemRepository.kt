package com.app.todo.Domain.Repository.Repositories

import com.app.todo.models.response.Item
import retrofit2.Response

interface BuyItemRepository {

    suspend fun getAllBuyItems(): Response<List<Item>>
}