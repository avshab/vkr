package ru.skillbranch.sbdelivery.dashboard.view.adapter

import ru.skillbranch.sbdelivery.common.view.adapter.BaseCellDelegatcionAdapter
import ru.skillbranch.sbdelivery.common.view.adapter.diff.BaseDiffCallback
import ru.skillbranch.sbdelivery.dashboard.view.delegates.DashboardAdCellDelegate
import ru.skillbranch.sbdelivery.dashboard.view.delegates.DashboardSubtitleCellDelegate
import ru.skillbranch.sbdelivery.dashboard.view.delegates.HorizontalDishesRVCellDelegate

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

class DashboardAdapter(

) : BaseCellDelegatcionAdapter(BaseDiffCallback()) {

    init {
        with(delegatesManager) {
            addDelegate(
                HorizontalDishesRVCellDelegate()
            )

            addDelegate(DashboardAdCellDelegate())

            addDelegate(DashboardSubtitleCellDelegate())
        }
    }
}

