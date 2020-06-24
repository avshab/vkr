package ru.skillbranch.sbdelivery.dashboard.view.cells

import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

class HorizontalDishesRVCell(val data: List<DishModel>) : IdentifiableCell<String> {

    companion object {
        const val VIEW_TYPE: Int = R.layout.cell_horizontal_rv
    }

    override val cellId: String = data.joinToString { it.id.toString() }

    override val cellLayout: Int = VIEW_TYPE

}