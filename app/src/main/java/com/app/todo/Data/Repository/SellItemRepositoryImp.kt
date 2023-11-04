package com.app.todo.DataSource.LocalDataSource.Repository

import androidx.lifecycle.LiveData
import com.app.todo.DataSource.LocalDataSource.TodoDao
import com.app.todo.Domain.Repository.Repositories.SellItemRepository
import com.app.todo.models.response.Item

class SellItemRepositoryImp(private val dao: TodoDao) : SellItemRepository {
    override suspend fun addSellItem(item: List<Item>) {
        dao.addSellItem(item)
    }

    override suspend fun getSellItems(): LiveData<List<Item>> {
        return dao.getAllItems()
    }

    override suspend fun updateSellItem(item: Item) {
        return dao.updateSellItem(item)
    }


    override suspend fun removeAll() {
        return dao.removeAll()
    }
}