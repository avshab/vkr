package ru.skillbranch.sbdelivery.dashboard.view.cells

import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell
import ru.skillbranch.sbdelivery.R

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

data class DishCardCell(val id: Long, val price: Int, val name: String) : IdentifiableCell<String> {

    companion object {
        const val VIEW_TYPE: Int = R.layout.cell_dish_card
    }

    override val cellId: String = id.toString() + price.toString() + name

    override val cellLayout: Int = VIEW_TYPE
}