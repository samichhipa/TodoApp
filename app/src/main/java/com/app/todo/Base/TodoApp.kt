package com.app.todo.Base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoApp : Application() {


    override fun onCreate() {
        super.onCreate()
        MultiDex.install(this)
        context = this
    }

    companion object {
        private lateinit var context: TodoApp
        fun getContext(): TodoApp {
            return context
        }
    }
}