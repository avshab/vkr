package ru.skillbranch.sbdelivery.auth.recovery.step3.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.domain.auth.usecases.RecoveryThirdStepUseCase
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.BehaviorState

/**
 * Created by Anna Shabaeva on 07.07.2020
 */

class RecoveryThirdStepViewModel(
    private val schedulers: Schedulers,
    private val recoveryThirdStepUseCase: RecoveryThirdStepUseCase,
    private val email: String,
    private val code: String
) : BaseViewModelWithState() {

    val passwordInputState = BehaviorState(EMPTY_STRING)
    val repeatPasswordInputState = BehaviorState(EMPTY_STRING)

    private var recoveryDisposable: Disposable? = null

    fun saveData() {
        if (passwordInputState.value == repeatPasswordInputState.value) {
            recoveryDisposable?.dispose()
            recoveryDisposable = recoveryThirdStepUseCase.build(
                email = email,
                code = code,
                password = passwordInputState.value
            )
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .subscribe(
                    ::handleResult,
                    ::handleError
                ).untilCleared()
        }
    }

    private fun handleResult(result: Any) {
        stateMutableLiveData.value = ViewModelState.Success(emptyList())
    }

}