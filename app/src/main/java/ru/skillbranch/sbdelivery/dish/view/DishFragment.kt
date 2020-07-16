package ru.skillbranch.sbdelivery.dish.view

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_dish.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.dish.model.DishViewModel
import ru.skillbranch.sbdelivery.dish.view.adapter.DishReviewAdapter
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

    override val toolbarVisibility: Boolean = false

    @Inject lateinit var viewModel: DishViewModel

    private val fragmentArgs by arguments<DishArgs>()

    private lateinit var reviewAdapter: DishReviewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        reviewAdapter = DishReviewAdapter(
            addReview = ::showReviewDialog,
            addToBasket = ::addToBasket
        )

        reviewRecyclerView.apply {
            adapter = reviewAdapter
            layoutManager = LinearLayoutManager(context)
        }
        setupSecondToolBar(fragmentArgs.dishModel.name)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.stateLiveData
            .observe(::handleState)
    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> reviewAdapter.items = state.list

        }
    }

    override fun onSendButtonClick(requestCode: Int, text: String, rating: Int) {
        super.onSendButtonClick(requestCode, text, rating)

        viewModel.addReview(rating, text)
    }

    private fun showReviewDialog() {
        showReviewDialog(RC_REVIEW_DIALOG)
    }

    private fun addToBasket() {
        viewModel.addToBasket()
    }
}