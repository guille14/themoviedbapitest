package com.gagl.moviedbapitest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.gagl.moviedbapitest.R
import com.gagl.moviedbapitest.databinding.MainActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val activityBinding by lazy { DataBindingUtil.setContentView<MainActivityBinding>(this, R.layout.main_activity) }
    //Explicacion en https://stackoverflow.com/a/59275182/2253682
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment }
    private val navController by lazy { navHostFragment.navController }
    /**
     * Configuracion del toolbar, se le indica que los fragmentos de splashscreen, login y home deben ser tratados como root(para que no muestre el icono de back)
     */
    private val appBarConfiguration by lazy{ AppBarConfiguration(setOf(R.id.topRatedMovies)) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        with(activityBinding){
            setSupportActionBar(toolbar)
//            NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
            //Incluir para que el navcontroller actualice el toolbar,
            //que a la vez se usa como actionbar, al cual los fragmentos pueden añadir menuItems
//            NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration)
//            NavigationUI.setupWithNavController(toolbar, navController)
//            toolbar.setupWithNavController(navController, appBarConfiguration)
            setupActionBarWithNavController(navController, appBarConfiguration)
        }

        //Si el destino es la pantalla de splash o el login, no mostrar el toolbar
//        navController.addOnDestinationChangedListener { _, destination, _ ->
//            if (destination.id == R.id.navigationSplashScreen || destination.id == R.id.navigationLogin) {
//                activityBinding.toolbar.visibility = View.GONE
//            } else {
//                activityBinding.toolbar.visibility = View.VISIBLE
//            }
//        }
    }
}