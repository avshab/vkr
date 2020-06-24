package ru.skillbranch.sbdelivery.dashboard.view.cells

import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell

class DashboardAdCell :
    IdentifiableCell<Int> {

    companion object {
        const val VIEW_TYPE: Int =
            R.layout.cell_main_page_ad
    }

    override val cellId: Int = VIEW_TYPE

    override val cellLayout: Int = VIEW_TYPE
}