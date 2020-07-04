package ru.skillbranch.sbdelivery.main.view

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.GravityCompat
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.main.model.MainViewModel
import ru.skillbranch.sbdelivery.main.model.MainViewModelState
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone
import ru.skillbranch.sbdelivery.utils.extensions.onClick
import javax.inject.Inject

class MainActivity : AppCompatActivity(), BaseFragment.ToolbarHandler {

    @Inject lateinit var viewModel: MainViewModel

    private lateinit var logoutButton: AppCompatImageButton

    private lateinit var userNameTextView: AppCompatTextView

    private lateinit var userEmailTextView: AppCompatTextView

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
        initViews()
    }

    private fun initViews() {
        val navHeaderView = navView.getHeaderView(0)

        logoutButton = navHeaderView.findViewById(R.id.logoutButton)
        userNameTextView = navHeaderView.findViewById(R.id.userNameTextView)
        userEmailTextView = navHeaderView.findViewById(R.id.userEmailTextView)

        logoutButton.onClick(viewModel::logout)

        viewModel.stateLiveData.observe(this, Observer(::handleState))
    }

    private fun handleState(state: MainViewModelState) {
        Log.i("--TAG", "SET STATE")
        when(state) {
            is MainViewModelState.AuthState -> {
                userNameTextView.text = state.userName
                userEmailTextView.text = state.email
            }
            is MainViewModelState.NoAuthState -> {
                userNameTextView.text = EMPTY_STRING
                userEmailTextView.text = EMPTY_STRING
            }
//            is MainViewModelState.Error -> shortToast(state.message)
//            is MainViewModelState.Loading -> shortToast("Подождите, действие выполняется")
        }
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

    override fun setVisibility(isVisibly: Boolean) {
       toolbar?.makeVisibleOrGone(isVisibly)
    }
}