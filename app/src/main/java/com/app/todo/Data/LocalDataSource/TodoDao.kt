package com.app.todo.DataSource.LocalDataSource

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.todo.Models.Response.Item

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSellItem(item: Item)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateSellItem(item: Item)

    @Query("SELECT * FROM ItemToSell")
    fun getAllItems(): LiveData<List<Item>>

    @Delete
    suspend fun remove(item: Item)
}