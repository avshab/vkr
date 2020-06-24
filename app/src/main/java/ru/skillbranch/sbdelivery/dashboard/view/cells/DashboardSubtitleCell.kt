package ru.skillbranch.sbdelivery.dashboard.view.cells

import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell

data class DashboardSubtitleCell(val title: String, val buttonText: String) :
    IdentifiableCell<String> {

    companion object {
        const val VIEW_TYPE: Int =
            R.layout.cell_dashboard_subtitles
    }

    override val cellId: String = title

    override val cellLayout: Int = VIEW_TYPE
}