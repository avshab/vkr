package ru.skillbranch.sbdelivery.di.domain

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
import ru.skillbranch.sbdelivery.domain.auth.gateway.LogoutGateway
import ru.skillbranch.sbdelivery.domain.auth.usecases.*
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway
import ru.skillbranch.sbdelivery.domain.dashboard.usecases.GetDashboardModelUseCases
import ru.skillbranch.sbdelivery.domain.profile.gateways.ProfileGateway
import ru.skillbranch.sbdelivery.domain.profile.usecases.GetAndUpdateProfileUseCases

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class UseCasesModule {

    @Provides
    fun provideGetDashboardModelUseCases(dashboardGateway: DashboardGateway) =
        GetDashboardModelUseCases(dashboardGateway = dashboardGateway)

    @Provides
    fun provideLoginUseCases(loginGateway: LoginGateway) =
        LoginUseCases(gateway = loginGateway)

    @Provides
    fun provideIsUserAuthorizedUseCase(loginGateway: LoginGateway) =
        IsUserAuthorizedUseCase(
            gateway = loginGateway
        )

    @Provides
    fun provideLogoutUseCase(logoutGateway: LogoutGateway) =
        LogoutUseCase(logoutGateway = logoutGateway)

    @Provides
    fun provideObserveUserAuthStatusUseCase(loginGateway: LoginGateway) =
        ObserveUserAuthStatusUseCase(loginGateway = loginGateway)

    @Provides
    fun provideGetAndUpdateProfileUseCases(gateway: ProfileGateway) =
        GetAndUpdateProfileUseCases(gateway = gateway)

    @Provides
    fun provideRegisterUseCases(loginGateway: LoginGateway) = RegisterUseCases(gateway = loginGateway)

    @Provides
    fun provideRecoveryFirstStepUseCase(loginGateway: LoginGateway) = RecoveryFirstStepUseCase(gateway = loginGateway)

    @Provides
    fun provideRecoverySecondStepUseCase(loginGateway: LoginGateway) = RecoverySecondStepUseCase(gateway = loginGateway)

    @Provides
    fun provideRecoveryThirdStepUseCase(loginGateway: LoginGateway) = RecoveryThirdStepUseCase(gateway = loginGateway)
}