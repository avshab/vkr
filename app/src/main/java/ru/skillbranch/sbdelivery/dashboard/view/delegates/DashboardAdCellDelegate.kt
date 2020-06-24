package ru.skillbranch.sbdelivery.dashboard.view.delegates

import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dashboard.view.cells.DashboardAdCell

class DashboardAdCellDelegate: BaseCellDelegate<DashboardAdCell>(
    DashboardAdCell.VIEW_TYPE
) {

    override fun onBindCell(cell: DashboardAdCell, viewHolder: BaseCellViewHolder) {
    }
}