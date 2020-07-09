package ru.skillbranch.sbdelivery.auth.recovery.step2.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.domain.auth.usecases.RecoverySecondStepUseCase
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.BehaviorState

/**
 * Created by Anna Shabaeva on 07.07.2020
 */

class RecoverySecondStepViewModel(
    private val schedulers: Schedulers,
    private val recoverySecondStepUseCase: RecoverySecondStepUseCase,
    private val email: String
) : BaseViewModelWithState() {

    val box1State = BehaviorState(EMPTY_STRING)
    val box2State = BehaviorState(EMPTY_STRING)
    val box3State = BehaviorState(EMPTY_STRING)
    val box4State = BehaviorState(EMPTY_STRING)

    private var recoveryDisposable: Disposable? = null

    val code: String
        get() = box1State.value + box2State.value + box3State.value + box4State.value

    fun sendCode() {
        recoveryDisposable?.dispose()
        recoveryDisposable = recoverySecondStepUseCase.build(email = email, code = code)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe(
                ::handleResult,
                ::handleError
            ).untilCleared()
    }

    private fun handleResult(result: Any) {
        stateMutableLiveData.value = ViewModelState.Success(emptyList())
    }
}