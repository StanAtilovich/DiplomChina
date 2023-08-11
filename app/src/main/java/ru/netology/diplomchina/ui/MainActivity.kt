package ru.netology.diplomchina.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import ru.netology.diplomchina.R
import ru.netology.diplomchina.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navController =
            findNavController(androidx.navigation.fragment.R.id.nav_host_fragment_container)
        NavigationUI.setupWithNavController(binding.drawerNavView, navController)
        binding.drawerNavView.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.mainDrawerLayout)

        binding.drawerNavView.getHeaderView(0).setOnClickListener {
            navController.navigate(R.id.nav_profile_fragment)
            if (binding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (binding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.mainDrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, binding.mainDrawerLayout)
    }
}