package ru.skillbranch.sbdelivery.auth.login.di


import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.auth.login.model.LoginViewModel
import ru.skillbranch.sbdelivery.auth.login.view.LoginFragment
import ru.skillbranch.sbdelivery.domain.auth.usecases.LoginUseCases
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.viewModel.createViewModel
import javax.inject.Provider

/**
 * Created by Anna Shabaeva on 26.06.2020
 */

@Module
class LoginModule {

    @Provides
    @LoginScope
    fun provideLoginViewModel(
        fragment: LoginFragment,
        schedulers: Provider<Schedulers>,
        loginUseCases: LoginUseCases
    ): LoginViewModel {
        return fragment.createViewModel {
            LoginViewModel(
                schedulers = schedulers.get(),
                loginUseCases = loginUseCases
            )
        }
    }
}