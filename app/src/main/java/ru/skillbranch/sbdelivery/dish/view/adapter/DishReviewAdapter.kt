package ru.skillbranch.sbdelivery.dish.view.adapter

import ru.skillbranch.sbdelivery.common.view.adapter.BaseCellDelegatcionAdapter
import ru.skillbranch.sbdelivery.common.view.adapter.diff.BaseDiffCallback
import ru.skillbranch.sbdelivery.dish.view.delegates.DishHeaderCellDelegate
import ru.skillbranch.sbdelivery.dish.view.delegates.ReviewCellDelegate
import ru.skillbranch.sbdelivery.dish.view.delegates.ReviewHeaderCellDelegate

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

class DishReviewAdapter(
    private val addToBasket: () -> Unit,
    private val addReview: () -> Unit
) : BaseCellDelegatcionAdapter(BaseDiffCallback()) {

    init {
        with(delegatesManager) {
            addDelegate(
                ReviewCellDelegate()
            )
            addDelegate(ReviewHeaderCellDelegate(addReview = addReview))

            addDelegate(DishHeaderCellDelegate(addToBasket = addToBasket))
        }
    }
}