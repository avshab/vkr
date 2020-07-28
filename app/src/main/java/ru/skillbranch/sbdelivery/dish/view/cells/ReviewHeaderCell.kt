package ru.skillbranch.sbdelivery.dish.view.cells

import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell

class ReviewHeaderCell(val rating: String) :
    IdentifiableCell<String> {
    companion object {
        const val VIEW_TYPE: Int =
            R.layout.cell_review_header
    }

    override val cellId: String = VIEW_TYPE.toString() + rating

    override val cellLayout: Int = VIEW_TYPE
}