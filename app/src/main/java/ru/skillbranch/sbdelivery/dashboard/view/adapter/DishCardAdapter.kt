package ru.skillbranch.sbdelivery.dashboard.view.adapter

import ru.skillbranch.sbdelivery.common.view.adapter.BaseCellDelegatcionAdapter
import ru.skillbranch.sbdelivery.common.view.adapter.diff.BaseDiffCallback
import ru.skillbranch.sbdelivery.dashboard.view.delegates.DishCardCellDelegate
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel

class DishCardAdapter(
    onDishClicked: (data: DishModel) -> Unit,
    addToBasket: () -> Unit,
    likeItem: () -> Unit
) : BaseCellDelegatcionAdapter(
    BaseDiffCallback()
) {

    init {
        with(delegatesManager) {
            addDelegate(
                DishCardCellDelegate(
                    onDishClicked = onDishClicked,
                    addToBasket = addToBasket,
                    likeItem = likeItem
                )
            )
        }
    }
}