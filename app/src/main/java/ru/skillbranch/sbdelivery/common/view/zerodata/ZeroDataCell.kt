package ru.skillbranch.sbdelivery.common.view.zerodata

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull
import ru.skillbranch.sbdelivery.R

/**
 * Created by Anna Shabaeva on 05.07.2020
 */
class ZeroDataCell(
    @StringRes val titleRes: Int,
    @DrawableRes val iconRes: Int,
    @StringRes val contentMessageRes: Int? = null,
    @StringRes val buttonTextRes: Int? = null
) : BaseCell, IdentifiableCell<Int> {

    companion object {
        const val VIEW_TYPE: Int = R.layout.cell_zero_data
        const val DEFAULT_MIN_HEIGHT_PD: Int = 300
    }

    override val cellLayout: Int = VIEW_TYPE

    override val cellId: Int =
        titleRes + iconRes + contentMessageRes.defaultIfNull + buttonTextRes.defaultIfNull
}

