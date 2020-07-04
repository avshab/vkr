package ru.skillbranch.sbdelivery.launch.view

import android.os.Bundle
import android.view.View
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.launch.model.LaunchViewModel
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

class LaunchFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_launch

    override val toolbarVisibility = false

    @Inject lateinit var viewModel: LaunchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.stateLiveData.observe(::navigate)
    }

    private fun navigate(navigate: Boolean) {

        navController.navigate(
            R.id.action_launch_to_dashboardFragment
        )
    }
}