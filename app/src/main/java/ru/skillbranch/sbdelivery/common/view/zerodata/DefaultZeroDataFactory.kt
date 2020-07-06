package ru.skillbranch.sbdelivery.common.view.zerodata

import ru.skillbranch.sbdelivery.R

class DefaultZeroDataFactory(): ZeroDataFactory {
    override fun buildZeroDataCell() = ZeroDataCell(
        titleRes = R.string.zero_cell_no_data_title,
        contentMessageRes = R.string.zero_cell_no_data_content,
        iconRes = R.drawable.ic_bowl_full_of_food
    )

    override fun buildZeroDataErrorCell(error: Throwable) = ZeroDataCell(
        titleRes = R.string.zero_cell_error_no_data_title,
        contentMessageRes = R.string.zero_cell_error_no_data_content,
        iconRes = R.drawable.ic_error_unspecified
    )
}