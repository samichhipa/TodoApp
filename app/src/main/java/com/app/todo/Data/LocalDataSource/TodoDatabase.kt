package com.app.todo.DataSource.LocalDataSource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.todo.models.response.Item

@Database(
    entities = [Item::class],
    version = 1
)
abstract class TodoDatabase : RoomDatabase() {

    abstract val todoDao: TodoDao

    companion object {
        const val DB_NAME = "todo_db"
    }
}