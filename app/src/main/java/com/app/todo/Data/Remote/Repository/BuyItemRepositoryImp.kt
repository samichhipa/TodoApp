package com.app.todo.DataSource.LocalDataSource.Remote.Repository

import com.app.todo.Domain.Repository.Repositories.BuyItemRepository
import com.app.todo.Models.Response.Item
import com.app.todo.Retrofit.RetrofitClient
import retrofit2.Response

class BuyItemRepositoryImp : BuyItemRepository {
    override suspend fun getAllByItems(): Response<List<Item>> {
        return RetrofitClient.apiService.getBuy()
    }
}