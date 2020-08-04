package ru.skillbranch.sbdelivery.basket.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_basket.*
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.basket.model.BasketViewModel
import ru.skillbranch.sbdelivery.basket.view.adapter.BasketAdapter
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 28.07.2020
 */
class BasketFragment : BaseFragment() {
    override val layoutResId: Int = ru.skillbranch.sbdelivery.R.layout.fragment_basket

    @Inject lateinit var viewModel: BasketViewModel

    private lateinit var adapter: BasketAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BasketAdapter()

        basketRecyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.stateLiveData
            .observe(::handleState)

        viewModel.authStateLiveData
            .observe(::navigateToLogin)
    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> adapter.items = state.list

        }
    }

    private fun navigateToLogin(isAuth: Boolean) {
        //todo
//        if (!isAuth) {
//            navController.navigate(R.id.action_dashboardFragment_to_loginFragment)
//        }
        //  viewModel.removeAuthObserver()
    }



}