package ru.skillbranch.sbdelivery.common.view.cells.base

import ru.skillbranch.sbdelivery.common.view.cells.BaseCell

/**
 * Created by Anna Shabaeva on 19.06.2020
 */
interface IdentifiableCell<T> : BaseCell {

    val cellId: T

}