package ru.skillbranch.sbdelivery.auth.recovery.step3.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.auth.recovery.step3.model.RecoveryThirdStepViewModel
import ru.skillbranch.sbdelivery.auth.recovery.step3.view.RecoveryThirdStepArgs
import ru.skillbranch.sbdelivery.auth.recovery.step3.view.RecoveryThirdStepFragment
import ru.skillbranch.sbdelivery.domain.auth.usecases.RecoveryThirdStepUseCase
import ru.skillbranch.sbdelivery.utils.extensions.getArgs
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 07.07.2020
 */


@Module
class RecoveryThirdStepModule {

    @Provides
    @RecoveryThirdStepScope
    fun provideRecoveryThirdStepArgs(
        fragment: RecoveryThirdStepFragment
    ): RecoveryThirdStepArgs {
        return fragment
            .getArgs<RecoveryThirdStepArgs> { fragment.arguments }
            .value
    }

    @Provides
    @RecoveryThirdStepScope
    fun provideRecoveryThirdStepViewModel(
        fragment: RecoveryThirdStepFragment,
        schedulers: Provider<Schedulers>,
        recoveryThirdStepUseCase: Provider<RecoveryThirdStepUseCase>,
        args: Provider<RecoveryThirdStepArgs>
    ): RecoveryThirdStepViewModel {
        return fragment.createViewModel {
            val args = args.get()
            RecoveryThirdStepViewModel(
                schedulers = schedulers.get(),
                recoveryThirdStepUseCase = recoveryThirdStepUseCase.get(),
                email = args.email,
                code = args.code
            )
        }
    }
}