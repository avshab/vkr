package ru.skillbranch.sbdelivery.auth.login.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.domain.auth.usecases.LoginUseCases
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.viewModel.BehaviorState

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginViewModel(private val schedulers: Schedulers, private val loginUseCases: LoginUseCases) :
    BaseViewModelWithState() {

    val userEmailInputState = BehaviorState(EMPTY_STRING)
    val userPasswordInputState = BehaviorState(EMPTY_STRING)

    private var loginDisposable: Disposable? = null

    fun debugLogin() {
        loginDisposable?.dispose()
        loginDisposable =
            loginUseCases.build(email = "rad@yandex.com", password = "Test12345")
                .subscribeOn(schedulers.io()).observeOn(schedulers.ui()).subscribe({
                    stateMutableLiveData.value = ViewModelState.Success(emptyList())
                }, ::handleError).untilCleared()
    }

    fun login() {
        loginDisposable?.dispose()
        loginDisposable =
            loginUseCases.build(
                email = userEmailInputState.value,
                password = userPasswordInputState.value
            )
                .subscribeOn(schedulers.io()).observeOn(schedulers.ui()).subscribe({
                    stateMutableLiveData.value = ViewModelState.Success(emptyList())
                }, ::handleError).untilCleared()
    }
}