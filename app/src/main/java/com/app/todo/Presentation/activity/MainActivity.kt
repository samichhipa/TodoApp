package com.app.todo.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.app.todo.R
import com.app.todo.ViewModels.BuySellItemViewModel
import com.app.todo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var buySellVM: BuySellItemViewModel? = null
    lateinit var navController: NavController
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = resources.getString(R.string.home_lbl)

        var navHostFragment =
            supportFragmentManager.findFragmentById(R.id.mainController) as NavHostFragment
        navController = navHostFragment.navController
        binding.toolbar.setupWithNavController(navController)
        buySellVM = ViewModelProvider(this)[BuySellItemViewModel::class.java]

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}