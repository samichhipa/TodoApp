package com.app.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.app.todo.Base.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}