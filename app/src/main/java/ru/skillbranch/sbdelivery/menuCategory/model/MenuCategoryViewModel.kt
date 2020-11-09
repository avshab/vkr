package ru.skillbranch.sbdelivery.menuCategory.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.menuCategory.view.MenuCategoryCellsBuilder
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

class MenuCategoryViewModel(
    private val catetegoryId: String,
    private val schedulers: Schedulers,
    private val builder: MenuCategoryCellsBuilder
) : BaseViewModelWithState() {

    private var dataDisposable: Disposable? = null

    private fun loadData() {

    }


}