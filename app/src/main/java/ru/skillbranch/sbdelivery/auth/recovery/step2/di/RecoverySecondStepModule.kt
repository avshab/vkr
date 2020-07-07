package ru.skillbranch.sbdelivery.auth.recovery.step2.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.auth.recovery.step2.model.RecoverySecondStepViewModel
import ru.skillbranch.sbdelivery.auth.recovery.step2.view.RecoverySecondStepFragment
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
    fun provideRecoverySecondStepViewModel(
        fragment: RecoverySecondStepFragment,
        schedulers: Provider<Schedulers>
    ): RecoverySecondStepViewModel {
        return fragment.createViewModel {
            RecoverySecondStepViewModel(
               schedulers = schedulers.get()
            )
        }
    }
}