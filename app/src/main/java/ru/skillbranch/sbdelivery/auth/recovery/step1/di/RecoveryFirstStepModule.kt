package ru.skillbranch.sbdelivery.auth.recovery.step1.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.auth.recovery.step1.model.RecoveryFirstStepViewModel
import ru.skillbranch.sbdelivery.auth.recovery.step1.view.RecoveryFirstStepFragment
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider


/**
 * Created by Anna Shabaeva on 07.07.2020
 */

@Module
class RecoveryFirstStepModule {

    @Provides
    @RecoveryFirstStepScope
    fun provideRecoveryFirstStepViewModel(
        fragment: RecoveryFirstStepFragment,
        schedulers: Provider<Schedulers>
    ): RecoveryFirstStepViewModel {
        return fragment.createViewModel {
            RecoveryFirstStepViewModel(
                schedulers = schedulers.get()
            )
        }
    }
}