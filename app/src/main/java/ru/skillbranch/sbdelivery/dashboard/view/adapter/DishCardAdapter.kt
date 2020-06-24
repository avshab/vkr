package ru.skillbranch.sbdelivery.dashboard.view.adapter

import ru.skillbranch.sbdelivery.common.view.adapter.BaseCellDelegatcionAdapter
import ru.skillbranch.sbdelivery.common.view.adapter.diff.BaseDiffCallback
import ru.skillbranch.sbdelivery.dashboard.view.delegates.DishCardCellDelegate

class DishCardAdapter : BaseCellDelegatcionAdapter(
    BaseDiffCallback()
) {

    init {
        with(delegatesManager) {
            addDelegate(
                DishCardCellDelegate()
            )
        }
    }
}