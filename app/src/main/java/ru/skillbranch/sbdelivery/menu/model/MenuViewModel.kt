package ru.skillbranch.sbdelivery.menu.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel
import ru.skillbranch.sbdelivery.domain.menu.usecases.GetMenuUseCases
import ru.skillbranch.sbdelivery.menu.view.MenuCellsBuilder
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 24.06.2020
 */

class MenuViewModel(
    private val schedulers: Schedulers,
    private val builder: MenuCellsBuilder,
    private val getMenuUseCases: GetMenuUseCases
) : BaseViewModelWithState() {

    private var dataDisposable: Disposable? = null

    init {
        loadData()
    }

    private fun loadData() {
        dataDisposable?.dispose()
        dataDisposable = getMenuUseCases
            .buildSingle()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe { stateMutableLiveData.value = ViewModelState.Loading }
            .subscribe(
                ::handleResult,
                ::handleError
            )
            .untilCleared()

    }

    private fun handleResult(data: List<CategoryModel>) {
        stateMutableLiveData.value = ViewModelState.Success(builder.build(data))
    }
}