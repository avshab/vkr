package ru.skillbranch.sbdelivery.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.sbdelivery.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
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
        return when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}