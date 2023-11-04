package com.app.todo

import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.app.todo.Base.BaseActivity
import com.app.todo.ViewModels.BuySellItemViewModel
import com.app.todo.ViewModels.CallsViewModel
import com.app.todo.databinding.ActivityMainBinding
import com.app.todo.presentation.fragments.BuyFragment
import com.app.todo.presentation.fragments.CallFragment
import com.app.todo.presentation.fragments.HomeFragment
import com.app.todo.presentation.fragments.SellFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

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