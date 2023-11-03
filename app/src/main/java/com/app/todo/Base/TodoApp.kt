package com.app.todo.Base

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApp : Application() {


    override fun onCreate() {
        super.onCreate()

        context = this
    }

    companion object {
        private lateinit var context: TodoApp
        fun getContext(): TodoApp {
            return context
        }
    }
}