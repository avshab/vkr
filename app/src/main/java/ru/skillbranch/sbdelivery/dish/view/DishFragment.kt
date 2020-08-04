package ru.skillbranch.sbdelivery.dish.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_dish.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.dish.model.DishViewModel
import ru.skillbranch.sbdelivery.dish.view.adapter.DishAdapter
import ru.skillbranch.sbdelivery.utils.extensions.arguments
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 11.07.2020
 */

class DishFragment : BaseFragment(), ReviewDialogFragment.Callback {

    private companion object {
        private const val RC_REVIEW_DIALOG = 200013
    }

    override val layoutResId: Int = R.layout.fragment_dish

    @Inject lateinit var viewModel: DishViewModel

    private val fragmentArgs by arguments<DishArgs>()

    private lateinit var dishAdapter: DishAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dishAdapter = DishAdapter(
            addReview = ::showReviewDialog,
            addToBasket = ::addToBasket
        )

        reviewRecyclerView.apply {
            adapter = adapter
            layoutManager = LinearLayoutManager(context)
        }

        setToolbarTitle(fragmentArgs.dishModel.name)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.stateLiveData
            .observe(::handleState)

        viewModel.authStateLiveData
            .observe(::navigateToLogin)
    }

    private fun navigateToLogin(isAuth: Boolean) {
        if (!isAuth) {
            navController.navigate(R.id.action_dashboardFragment_to_loginFragment)
        }
      //  viewModel.removeAuthObserver()
    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> dishAdapter.items = state.list

        }
    }

    override fun onSendButtonClick(requestCode: Int, text: String, rating: Int) {
        super.onSendButtonClick(requestCode, text, rating)

        viewModel.addReview(rating, text)
    }

    private fun showReviewDialog() {
        showReviewDialog(RC_REVIEW_DIALOG)
    }

    private fun addToBasket(count: Int) {

        Log.i("--TAG", "add to basket $count")
        viewModel.addToBasket(count)
    }
}