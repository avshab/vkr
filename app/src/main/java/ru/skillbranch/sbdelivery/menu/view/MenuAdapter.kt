package ru.skillbranch.sbdelivery.menu.view

import ru.skillbranch.sbdelivery.common.view.adapter.BaseCellDelegatcionAdapter
import ru.skillbranch.sbdelivery.common.view.adapter.diff.BaseDiffCallback

/**
 * Created by Anna Shabaeva on 24.06.2020
 */
class MenuAdapter(
    categoryClick: (id: String) -> Unit
) : BaseCellDelegatcionAdapter(
    BaseDiffCallback()
) {

    init {
        with(delegatesManager) {
            addDelegate(MenuCellDelegate(categoryClick))
        }
    }

}