package ru.skillbranch.sbdelivery.main.model

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.data.common.userData.UserDataStorage
import ru.skillbranch.sbdelivery.domain.auth.usecases.LogoutUseCase
import ru.skillbranch.sbdelivery.domain.auth.usecases.ObserveUserAuthStatusUseCase
import ru.skillbranch.sbdelivery.domain.profile.usecases.GetAndUpdateProfileUseCases
import ru.skillbranch.sbdelivery.domain.userData.model.UserDataModel
import ru.skillbranch.sbdelivery.utils.exceptions.WHITESPACE
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 03.07.2020
 */

class MainViewModel(
    private val schedulers: Schedulers,
    private val logoutUseCase: LogoutUseCase,
    private val authObserverUseCases: ObserveUserAuthStatusUseCase,
    private val userDataStorage: UserDataStorage,
    private val getAndUpdateProfileUseCases: GetAndUpdateProfileUseCases
) : BaseViewModel() {

    private var logoutDisposable: Disposable? = null
    private var authDisposable: Disposable? = null
    private var userDataDisposable: Disposable? = null

    private val stateMutableLiveData = MutableLiveData<MainViewModelState>()
    val stateLiveData = stateMutableLiveData.asLiveData

    init {
        authDisposable?.dispose()
        authDisposable = authObserverUseCases.buildObservable()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .distinctUntilChanged()
            .subscribe(
                ::handleAuthState,
                ::handleError
            )
            .untilCleared()
    }

    fun logout() {
        logoutDisposable?.dispose()
        logoutDisposable = logoutUseCase.buildCompletable()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe({
                stateMutableLiveData.value = MainViewModelState.NoAuthState
            }, ::handleError).untilCleared()
    }

    private fun handleAuthState(isAuth: Boolean) {
        if (isAuth) {
            userDataStorage.getUserData().apply {
                if (this != null) {
                    handleAuthData(this)
                } else {
                    userDataDisposable?.dispose()
                    userDataDisposable =
                        getAndUpdateProfileUseCases.build().subscribeOn(schedulers.io())
                            .observeOn(schedulers.ui())
                            .subscribe(
                                ::handleAuthData,
                                ::handleError
                            ).untilCleared()
                }
            }
        } else {
            stateMutableLiveData.value = MainViewModelState.NoAuthState
        }
    }

    private fun handleAuthData(data: UserDataModel) {
        stateMutableLiveData.value = MainViewModelState.AuthState(
            userName = data.lastName + WHITESPACE + data.firstName,
            email = data.email
        )
    }

    private fun handleError(throwable: Throwable) {
        stateMutableLiveData.value = MainViewModelState.Error(throwable.message.defaultIfNull)
    }
}

