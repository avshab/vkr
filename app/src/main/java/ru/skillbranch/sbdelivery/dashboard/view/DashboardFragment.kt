package ru.skillbranch.sbdelivery.dashboard.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dashboard.*
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.dashboard.model.DashboardViewModel
import ru.skillbranch.sbdelivery.dashboard.view.adapter.DashboardAdapter
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

        if(true) {
            navController.navigate(R.id.action_dashboardFragment_to_loginFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.stateLiveData
            .observe(::handleState)
    }

    private fun handleState(state: ViewModelState) {
        when(state) {
            is ViewModelState.Success -> dashboardAdapter.items = state.list
        }
    }

}