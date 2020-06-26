package ru.skillbranch.sbdelivery.menu.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_menu.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.menu.model.MenuViewModel
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 24.06.2020
 */
class MenuFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_menu

    @Inject lateinit var viewModel: MenuViewModel

    private lateinit var menuAdapter: MenuAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        menuAdapter = MenuAdapter()
        menuRecyclerView.apply {
            adapter = menuAdapter
            layoutManager = GridLayoutManager(context, 3)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.stateLiveData
            .observe(::handleState)
    }

    private fun handleState(state: ViewModelState) {

        when (state) {
            is ViewModelState.Success -> menuAdapter.items = state.list
        }

    }
}