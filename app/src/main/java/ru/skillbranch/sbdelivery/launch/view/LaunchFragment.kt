package ru.skillbranch.sbdelivery.launch.view

import android.os.Bundle
import android.view.View
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.dashboard.view.DashboardArguments
import ru.skillbranch.sbdelivery.dashboard.view.DashboardFragment
import ru.skillbranch.sbdelivery.launch.model.LaunchViewModel
import ru.skillbranch.sbdelivery.utils.extensions.postDelayed
import ru.skillbranch.sbdelivery.utils.extensions.toBundle
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

class LaunchFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_launch

    @Inject lateinit var viewModel: LaunchViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.authStateLiveData.observe(::navigate)
    }

    private fun navigate(isAuth: Boolean) {


            //navController.navigate(R.id.action_launch_to_authorizedNavigation)

        val args = DashboardArguments(hasAuth = isAuth)
            navController.navigate(R.id.action_launch_to_authorizedNavigation, args.toBundle<DashboardFragment>())


    }


}