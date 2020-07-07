package ru.skillbranch.sbdelivery.auth.recovery.step3.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.auth.recovery.step3.model.RecoveryThirdStepViewModel
import ru.skillbranch.sbdelivery.auth.recovery.step3.view.RecoveryThirdStepFragment
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
    fun provideRecoveryThirdStepViewModel(
        fragment: RecoveryThirdStepFragment,
        schedulers: Provider<Schedulers>
    ): RecoveryThirdStepViewModel {
        return fragment.createViewModel {
            RecoveryThirdStepViewModel(
                schedulers = schedulers.get()
            )
        }
    }
}