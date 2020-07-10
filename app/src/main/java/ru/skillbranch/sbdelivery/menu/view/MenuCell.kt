package ru.skillbranch.sbdelivery.menu.view

import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 24.06.2020
 */
data class MenuCell(val title: String, val iconUrl: String, val children: List<CategoryModel>) :
    IdentifiableCell<String> {

    companion object {
        const val VIEW_TYPE: Int =
            R.layout.cell_menu
    }

    override val cellId: String = title

    override val cellLayout: Int = VIEW_TYPE
}