package ru.skillbranch.sbdelivery.dashboard.view.adapter

import ru.skillbranch.sbdelivery.common.view.adapter.BaseCellDelegatcionAdapter
import ru.skillbranch.sbdelivery.common.view.adapter.diff.BaseDiffCallback
import ru.skillbranch.sbdelivery.common.view.zerodata.ZeroDataCellDelegate
import ru.skillbranch.sbdelivery.dashboard.view.delegates.DashboardAdCellDelegate
import ru.skillbranch.sbdelivery.dashboard.view.delegates.DashboardSubtitleCellDelegate
import ru.skillbranch.sbdelivery.dashboard.view.delegates.HorizontalDishesRVCellDelegate
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

class DashboardAdapter(
    onDishClicked: (data: DishModel) -> Unit,
    addToBasket: () -> Unit,
    likeItem: () -> Unit
) : BaseCellDelegatcionAdapter(BaseDiffCallback()) {

    init {
        with(delegatesManager) {
            addDelegate(
                HorizontalDishesRVCellDelegate(
                    onDishClicked = onDishClicked,
                    addToBasket = addToBasket,
                    likeItem = likeItem
                )
            )

            addDelegate(ZeroDataCellDelegate())

            addDelegate(DashboardAdCellDelegate())

            addDelegate(DashboardSubtitleCellDelegate())
        }
    }
}

