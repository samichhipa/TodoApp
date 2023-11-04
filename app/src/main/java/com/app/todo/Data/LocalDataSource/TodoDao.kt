package com.app.todo.DataSource.LocalDataSource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.todo.models.response.Item

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSellItem(item: List<Item>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSellItem(item: Item)

    @Query("SELECT * FROM ItemToSell")
    fun getAllItems(): LiveData<List<Item>>

    @Query("DELETE FROM ItemToSell")
    suspend fun removeAll()
}