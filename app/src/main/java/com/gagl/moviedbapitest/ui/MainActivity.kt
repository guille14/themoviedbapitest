package com.gagl.moviedbapitest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.gagl.moviedbapitest.R
import com.gagl.moviedbapitest.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val activityBinding by lazy { DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity) }
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment }
    private val navController by lazy { navHostFragment.navController }
    private val appBarConfiguration by lazy{ AppBarConfiguration(setOf(R.id.topRatedMovies)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        with(activityBinding){
            setSupportActionBar(toolbar)
            setupActionBarWithNavController(navController, appBarConfiguration)
        }
    }
}