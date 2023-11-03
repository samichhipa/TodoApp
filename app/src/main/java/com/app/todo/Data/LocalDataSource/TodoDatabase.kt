package com.app.todo.DataSource.LocalDataSource

import android.provider.CallLog
import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.todo.Models.Response.Item

@Database(
    entities = [Item::class, CallLog.Calls::class],
    version = 1
)
abstract class TodoDatabase : RoomDatabase() {

    abstract val todoDao: TodoDao

    companion object {
        const val DB_NAME = "todo_db"
    }
}