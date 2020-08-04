package ru.skillbranch.sbdelivery.launch.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.domain.auth.usecases.IsUserAuthorizedSingleUseCase
import ru.skillbranch.sbdelivery.launch.model.LaunchViewModel
import ru.skillbranch.sbdelivery.launch.view.LaunchFragment
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

@Module
class LaunchModule {

    @Provides
    @LaunchScope
    fun provideLaunchViewModel(
        fragment: LaunchFragment,
        schedulers: Provider<Schedulers>,
        isUserAuthorizedSingleUseCase: Provider<IsUserAuthorizedSingleUseCase>
    ): LaunchViewModel {
        return fragment.createViewModel {
            LaunchViewModel(
                schedulers = schedulers.get(),
                isUserAuthorizedSingleUseCase = isUserAuthorizedSingleUseCase.get()
            )
        }
    }
}