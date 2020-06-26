package ru.skillbranch.sbdelivery.menu.model

import androidx.lifecycle.MutableLiveData
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.menu.view.MenuCellsBuilder
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 24.06.2020
 */

class MenuViewModel(
    private val schedulers: Schedulers,
    private val builder: MenuCellsBuilder
) : BaseViewModel() {

    private val stateMutableLiveData = MutableLiveData<ViewModelState>()
    val stateLiveData = stateMutableLiveData.asLiveData

    init {
        loadData()
    }

    fun loadData() {
        handleResult()
    }

    private fun handleResult() {
        stateMutableLiveData.value = ViewModelState.Success(builder.build())
    }
}