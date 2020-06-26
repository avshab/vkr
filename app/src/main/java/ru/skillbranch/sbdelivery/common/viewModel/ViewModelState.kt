package ru.skillbranch.sbdelivery.common.viewModel

import ru.skillbranch.sbdelivery.common.view.cells.BaseCell

sealed class ViewModelState {

    object Loading : ViewModelState()

    data class Success(val list: List<BaseCell>) : ViewModelState()

    data class Error(val message: String) : ViewModelState()
}