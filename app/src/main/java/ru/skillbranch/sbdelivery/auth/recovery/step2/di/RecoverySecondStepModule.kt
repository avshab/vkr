package ru.skillbranch.sbdelivery.auth.recovery.step2.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.auth.recovery.step2.model.RecoverySecondStepViewModel
import ru.skillbranch.sbdelivery.auth.recovery.step2.view.RecoverySecondStepArgs
import ru.skillbranch.sbdelivery.auth.recovery.step2.view.RecoverySecondStepFragment
import ru.skillbranch.sbdelivery.domain.auth.usecases.RecoverySecondStepUseCase
import ru.skillbranch.sbdelivery.utils.extensions.getArgs
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 07.07.2020
 */


@Module
class RecoverySecondStepModule {


    @Provides
    @RecoverySecondStepScope
    fun provideRecoverySecondStepArgs(
        fragment: RecoverySecondStepFragment
    ): RecoverySecondStepArgs {
        return fragment
            .getArgs<RecoverySecondStepArgs> { fragment.arguments }
            .value
    }


    @Provides
    @RecoverySecondStepScope
    fun provideRecoverySecondStepViewModel(
        fragment: RecoverySecondStepFragment,
        schedulers: Provider<Schedulers>,
        recoverySecondStepUseCase: Provider<RecoverySecondStepUseCase>,
        args: Provider<RecoverySecondStepArgs>
    ): RecoverySecondStepViewModel {
        return fragment.createViewModel {
            val args = args.get()
            RecoverySecondStepViewModel(
               schedulers = schedulers.get(),
                recoverySecondStepUseCase = recoverySecondStepUseCase.get(),
                email = args.email
            )
        }
    }
}