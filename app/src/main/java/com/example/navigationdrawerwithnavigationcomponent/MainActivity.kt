package com.example.navigationdrawerwithnavigationcomponent

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupNavigationController()
    }

    private fun setupNavigationController() {

        setSupportActionBar(toolbar)

        val drawerToggle =
            ActionBarDrawerToggle(
                this@MainActivity,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
            )

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        toolbar.setNavigationOnClickListener(this@MainActivity)


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



    override fun onClick(v: View?) {
        if (drawerLayout.isDrawerOpen(Gravity.RIGHT))
            drawerLayout.closeDrawer(Gravity.RIGHT)
        else
            drawerLayout.openDrawer(Gravity.RIGHT)
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.END))
            drawerLayout.closeDrawer(GravityCompat.END)
        else
            super.onBackPressed()
    }


}
