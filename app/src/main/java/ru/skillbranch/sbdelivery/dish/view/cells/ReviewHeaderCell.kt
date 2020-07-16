package ru.skillbranch.sbdelivery.dish.view.cells

import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell

class ReviewHeaderCell :
    IdentifiableCell<Int> {
    companion object {
        const val VIEW_TYPE: Int =
            R.layout.cell_review_header
    }

    override val cellId: Int = VIEW_TYPE

    override val cellLayout: Int = VIEW_TYPE
}