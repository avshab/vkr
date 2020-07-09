package ru.skillbranch.sbdelivery.auth.recovery.step1.model

import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.domain.auth.usecases.RecoveryFirstStepUseCase
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.BehaviorState

/**
 * Created by Anna Shabaeva on 07.07.2020
 */

class RecoveryFirstStepViewModel(
    private val schedulers: Schedulers,
    private val recoveryFirstStepUseCase: RecoveryFirstStepUseCase
) : BaseViewModelWithState() {

    val userEmailInputState = BehaviorState(EMPTY_STRING)

    private var recoveryDisposable: Disposable? = null

    fun sendEmail() {
        recoveryDisposable?.dispose()
        recoveryDisposable = recoveryFirstStepUseCase.build(email = userEmailInputState.value)
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