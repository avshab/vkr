package ru.skillbranch.sbdelivery.dashboard.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.dashboard.view.builder.DashboardCellsBuilder
import ru.skillbranch.sbdelivery.domain.auth.usecases.IsUserAuthorizedSingleUseCase
import ru.skillbranch.sbdelivery.domain.dashboard.model.DashboardModel
import ru.skillbranch.sbdelivery.domain.dashboard.usecases.GetDashboardModelUseCases
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class DashboardViewModel(
    private val schedulers: Schedulers,
    isUserAuthorizedSingleUseCase: IsUserAuthorizedSingleUseCase,
    private val getDashboardModelUseCases: GetDashboardModelUseCases,
    private val cellsBuilder: DashboardCellsBuilder
) : BaseViewModelWithState() {

    private var authDisposable: Disposable? = null
    private var dataDisposable: Disposable? = null

    private val authStateDelegate = MutableLiveData<Boolean>()
    val authStateLiveData = authStateDelegate.asLiveData

    init {
        authDisposable?.dispose()
        authDisposable = isUserAuthorizedSingleUseCase.buildSingle().subscribeOn(schedulers.io())
            .observeOn(schedulers.ui()).subscribe(authStateDelegate::setValue).untilCleared()
        loadData()
    }

    fun removeAuthObserver() {
        authStateDelegate.value = null
    }

    fun reload() = loadData()

    private fun loadData() {
        dataDisposable?.dispose()
        dataDisposable = getDashboardModelUseCases
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

    private fun handleResult(data: DashboardModel) {
        data.ids.forEach {
            Log.i("--TAG", "recomend id --- ${it}")
        }

        data.dishes.forEach {
            Log.i("--TAG", "dishes id --- ${it.id} name: ${it.name}")
        }
        stateMutableLiveData.value = ViewModelState.Success(cellsBuilder.build(data))
    }

//    private fun handleError(throwable: Throwable) {
//        Log.i("--TAG", "handleError")
//    }
}