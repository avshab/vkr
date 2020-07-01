package ru.skillbranch.sbdelivery.dashboard.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.dashboard.view.builder.DashboardCellsBuilder
import ru.skillbranch.sbdelivery.domain.auth.login.IsUserAuthorizedUseCase
import ru.skillbranch.sbdelivery.domain.dashboard.model.DashboardModel
import ru.skillbranch.sbdelivery.domain.dashboard.usecases.GetDashboardModelUseCases
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class DashboardViewModel(
    private val schedulers: Schedulers,
    private val getDashboardModelUseCases: GetDashboardModelUseCases,
    private val cellsBuilder: DashboardCellsBuilder
) : BaseViewModel() {

    private var dataDisposable: Disposable? = null

    private val stateMutableLiveData = MutableLiveData<ViewModelState>()
    val stateLiveData = stateMutableLiveData.asLiveData

    init {
        loadData()
    }

    fun loadData() {
        Log.i("--TAG", "LOAD RECOMMENDATION LIST")
        dataDisposable?.dispose()
        dataDisposable = getDashboardModelUseCases.buildSingle().subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .doOnSubscribe { stateMutableLiveData.value = ViewModelState.Loading }
            .subscribe(::handleResult)
            .untilCleared()
    }

    private fun handleResult(data: DashboardModel) {
        data.ids.forEach {
            Log.i("--TAG", "recomend id --- ${it}")
        }

        data.dishes.forEach {
            Log.i("--TAG", "dishes id --- ${it.id} name: ${it.name}")
        }
        stateMutableLiveData.value = ViewModelState.Success(cellsBuilder.build(data))
    }
}