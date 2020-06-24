package ru.skillbranch.sbdelivery.dashboard.model

import ru.skillbranch.sbdelivery.common.view.cells.BaseCell

sealed class DashboardState {

    object Loading : DashboardState()

    data class Success(val list: List<BaseCell>) : DashboardState()

    data class Error(val message: String) : DashboardState()
}