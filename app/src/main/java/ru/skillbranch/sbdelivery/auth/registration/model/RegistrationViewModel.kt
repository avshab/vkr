package ru.skillbranch.sbdelivery.auth.registration.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.domain.auth.usecases.RegisterUseCases
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.BehaviorState

/**
 * Created by Anna Shabaeva on 26.06.2020
 */

class RegistrationViewModel(
    private val schedulers: Schedulers,
    private val registerUseCases: RegisterUseCases
) : BaseViewModelWithState() {

    val nameInputState = BehaviorState(EMPTY_STRING)
    val surnameInputState = BehaviorState(EMPTY_STRING)
    val userEmailInputState = BehaviorState(EMPTY_STRING)
    val userPasswordInputState = BehaviorState(EMPTY_STRING)

    private var registerDisposable: Disposable? = null

    fun register() {
        registerDisposable?.dispose()
        registerDisposable = registerUseCases.build(
            name = nameInputState.value,
            surname = surnameInputState.value,
            email = userEmailInputState.value,
            password = userPasswordInputState.value
        ).subscribeOn(schedulers.io()).observeOn(schedulers.ui()).subscribe({
            stateMutableLiveData.value = ViewModelState.Success(emptyList())
        }, ::handleError).untilCleared()

    }
}