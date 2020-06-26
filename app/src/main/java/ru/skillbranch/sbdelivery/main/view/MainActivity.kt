package ru.skillbranch.sbdelivery.main.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.sbdelivery.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppThemeClear)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
        navView.setupWithNavController(navController)

        setSupportActionBar(toolbar)
        navView.bringToFront()
        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.menu_open,
            R.string.menu_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private val navController
        get() = findNavController(R.id.mainNavHostFragment)

    private val navFragmentManager
        get() = mainNavHostFragment.childFragmentManager

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        NavigationUI.onNavDestinationSelected(item, navController)
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        return super.navigateUpTo(upIntent)

        Log.i("--TAG", "navigateUpTo")
    }

    override fun navigateUpToFromChild(child: Activity?, upIntent: Intent?): Boolean {
        return super.navigateUpToFromChild(child, upIntent)
        Log.i("--TAG", "navigateUpToFromChild ${child?.javaClass?.name}")
    }

    override fun onNavigateUpFromChild(child: Activity?): Boolean {
        return super.onNavigateUpFromChild(child)
        Log.i("--TAG", "onNavigateUpFromChild ${child?.javaClass?.name}")
    }
}