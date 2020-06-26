package ru.skillbranch.sbdelivery.menu.view

import ru.skillbranch.sbdelivery.common.view.cells.BaseCell

/**
 * Created by Anna Shabaeva on 24.06.2020
 */

class MenuCellsBuilder() {

    fun build(): List<BaseCell> {
        return listOf(
            MenuCell("Акции"),
            MenuCell("Комбо"),
            MenuCell("Пицца"),
            MenuCell("Суши и роллы"),
            MenuCell("Бургеры"),
            MenuCell("Супы"),
            MenuCell("Горячее")
        )
    }
}