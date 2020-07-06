package ru.skillbranch.sbdelivery.dashboard.view

import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_dashboard.*
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.dashboard.model.DashboardViewModel
import ru.skillbranch.sbdelivery.dashboard.view.adapter.DashboardAdapter
import ru.skillbranch.sbdelivery.utils.extensions.arguments
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class DashboardFragment : BaseFragment() {

    override val layoutResId = R.layout.fragment_dashboard

    @Inject lateinit var viewModel: DashboardViewModel

    private lateinit var dashboardAdapter: DashboardAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dashboardAdapter = DashboardAdapter()
        dashboardRecyclerView.apply {
            adapter = dashboardAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel.authStateLiveData.observe(::navigate)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.stateLiveData
            .observe(::handleState)

        viewModel.authStateLiveData
            .observe(::navigate)
    }

    private fun navigate(isAuth: Boolean) {
        if (!isAuth) {
            navController.navigate(R.id.action_dashboardFragment_to_loginFragment)
        }
        viewModel.removeAuthObserver()
    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> dashboardAdapter.items = state.list
            is ViewModelState.Error -> dashboardAdapter.items = state.zeroCell
        }
    }

}