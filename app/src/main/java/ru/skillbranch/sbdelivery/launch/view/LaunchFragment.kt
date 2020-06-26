package ru.skillbranch.sbdelivery.launch.view

import android.os.Bundle
import android.view.View
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.utils.extensions.postDelayed

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

class LaunchFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_launch

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onResume() {
        super.onResume()

            navController.navigate(R.id.action_launch_to_authorizedNavigation)

    }


}