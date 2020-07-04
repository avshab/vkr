package ru.skillbranch.sbdelivery.main.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.common.userData.UserDataStorage
import ru.skillbranch.sbdelivery.domain.auth.usecases.LogoutUseCase
import ru.skillbranch.sbdelivery.domain.auth.usecases.ObserveUserAuthStatusUseCase
import ru.skillbranch.sbdelivery.domain.profile.usecases.GetAndUpdateProfileUseCases
import ru.skillbranch.sbdelivery.main.model.MainViewModel
import ru.skillbranch.sbdelivery.main.view.MainActivity
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 03.07.2020
 */

@Module
class MainModule {

    @Provides
    @MainScope
    fun provideMainViewModel(
        activity: MainActivity,
        schedulers: Provider<Schedulers>,
        logoutUseCases: Provider<LogoutUseCase>,
        authObserverUseCases: Provider<ObserveUserAuthStatusUseCase>,
        getAndUpdateProfileUseCases: Provider<GetAndUpdateProfileUseCases>,
        userDataStorage: UserDataStorage
    ) : MainViewModel {
        return  activity.createViewModel {
            MainViewModel(
                schedulers = schedulers.get(),
                logoutUseCase = logoutUseCases.get(),
                authObserverUseCases = authObserverUseCases.get(),
                getAndUpdateProfileUseCases = getAndUpdateProfileUseCases.get(),
                userDataStorage = userDataStorage
            )
        }
    }
}