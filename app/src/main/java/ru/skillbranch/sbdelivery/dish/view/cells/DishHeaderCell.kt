package ru.skillbranch.sbdelivery.dish.view.cells

import android.text.Spannable
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell

data class DishHeaderCell(
    val title: String,
    val description: String,
    val url: String,
    val price: Spannable,
    val isDiscount: Boolean
) :
    IdentifiableCell<String> {
    companion object {
        const val VIEW_TYPE: Int =
            R.layout.cell_dish_header
    }

    override val cellId: String = title + description

    override val cellLayout: Int = VIEW_TYPE
}