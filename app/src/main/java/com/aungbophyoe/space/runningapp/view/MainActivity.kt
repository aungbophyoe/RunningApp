package com.aungbophyoe.space.runningapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.aungbophyoe.space.runningapp.R
import com.aungbophyoe.space.runningapp.data.RunDAO
import com.aungbophyoe.space.runningapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private var _binding : ActivityMainBinding? = null
    private val binding get() = _binding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view =_binding!!.root
        setContentView(view)
        binding!!.apply {
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            /*navController = findNavController(R.id.nav_host_fragment)*/
            navController = navHostFragment.navController
            /*val appBarConfiguration = AppBarConfiguration(setOf(R.id.home,R.id.setting))
            setupActionBarWithNavController(navController,appBarConfiguration)*/
            bottomNavigationView.setupWithNavController(navController)
            navController.addOnDestinationChangedListener{_, destination ,_ ->
                when(destination.id){
                    R.id.runFragment,R.id.settingFragment,R.id.statisticsFragment -> bottomNavigationView.visibility = View.VISIBLE
                    else -> bottomNavigationView.visibility = View.GONE
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}