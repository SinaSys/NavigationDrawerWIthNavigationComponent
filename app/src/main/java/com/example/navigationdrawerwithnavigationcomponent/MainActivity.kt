package com.example.navigationdrawerwithnavigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationController()
    }

    private fun setupNavigationController() {

        /**
         * with these two lines below navigation drawer work with swipe
         * but we don't set icon for that in toolbar yet
         */
        navController = findNavController(R.id.hostFragment)
        NavigationUI.setupWithNavController(navigationView, navController)


        /**
         * this line below and onSupportNavigateUp() method below used for set icon for toolbar
         * and with these two parts of code navigation drawer work properly
         */
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navController,
            drawerLayout
        )
    }

}
