package ru.skillbranch.sbdelivery.auth.registration.di

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.auth.registration.model.RegistrationViewModel
import ru.skillbranch.sbdelivery.auth.registration.view.RegistrationFragment
import ru.skillbranch.sbdelivery.domain.auth.usecases.RegisterUseCases
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 26.06.2020
 */

@Module
class RegistrationModule {

    @Provides
    @RegistrationScope
    fun provideRegistrationViewModel(
        fragment: RegistrationFragment,
        schedulers: Provider<Schedulers>,
        registerUseCases: Provider<RegisterUseCases>
    ) : RegistrationViewModel {
        return fragment.createViewModel {
            RegistrationViewModel(
                schedulers = schedulers.get(),
                registerUseCases = registerUseCases.get()
            )
        }
    }
}