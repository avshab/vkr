package ru.skillbranch.sbdelivery.common.viewModel

import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.common.view.zerodata.ZeroDataCell

sealed class ViewModelState {

    object Loading : ViewModelState()

    data class Success(val list: List<BaseCell>) : ViewModelState()

    data class Error(val zeroCell: List<ZeroDataCell>, val message: String) : ViewModelState()
}