package ru.skillbranch.sbdelivery.dashboard.view.delegates

import kotlinx.android.synthetic.main.cell_dashboard_subtitles.view.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dashboard.view.cells.DashboardSubtitleCell

class DashboardSubtitleCellDelegate :
    BaseCellDelegate<DashboardSubtitleCell>(
        DashboardSubtitleCell.VIEW_TYPE
    ) {

    override fun onBindCell(cell: DashboardSubtitleCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder.itemView) {
            sectionTitleTextView.text = cell.title
            sectionButton.text = cell.buttonText
        }
    }
}