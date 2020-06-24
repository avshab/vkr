package ru.skillbranch.sbdelivery.dashboard.view.builder

import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.dashboard.view.cells.DashboardAdCell
import ru.skillbranch.sbdelivery.dashboard.view.cells.DashboardSubtitleCell
import ru.skillbranch.sbdelivery.dashboard.view.cells.HorizontalDishesRVCell
import ru.skillbranch.sbdelivery.domain.dashboard.model.DashboardModel
import ru.skillbranch.sbdelivery.utils.resources.ResourcesManager

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

class DashboardCellsBuilder(private val resourcesManager: ResourcesManager) {

    fun build(data: DashboardModel): List<BaseCell> {
        val btnText = resourcesManager.getString(R.string.dashboard_all_items)
        return listOf(
            DashboardAdCell(),
            DashboardSubtitleCell(
                title = resourcesManager.getString(R.string.dashboard_recommended_section),
                buttonText = btnText
            ),
            HorizontalDishesRVCell(data.dishes)
        )
    }
}