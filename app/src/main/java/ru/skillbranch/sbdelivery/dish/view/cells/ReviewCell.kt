package ru.skillbranch.sbdelivery.dish.view.cells

import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell
import ru.skillbranch.sbdelivery.R

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

data class ReviewCell(val title: String, val rating: Int, val text: String) :
    IdentifiableCell<String> {
    companion object {
        const val VIEW_TYPE: Int = R.layout.cell_review_item
    }

    override val cellId: String = title + rating.toString() + text

    override val cellLayout: Int = VIEW_TYPE
}