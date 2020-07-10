package ru.skillbranch.sbdelivery.menu.view

import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull

/**
 * Created by Anna Shabaeva on 24.06.2020
 */

class MenuCellsBuilder() {

    fun build(data: List<CategoryModel>): List<BaseCell> {
        val res = data.filter { it.active && it.parent == null }.map {
            MenuCell(title = it.name, iconUrl = it.icon.defaultIfNull, children = listOf())
        }
        return  data.filter { it.active && it.parent == null }.map {
            MenuCell(title = it.name, iconUrl = it.icon.defaultIfNull, children = listOf())
        }
    }
}