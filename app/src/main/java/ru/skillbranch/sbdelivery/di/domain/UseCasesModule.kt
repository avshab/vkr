package ru.skillbranch.sbdelivery.di.domain

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
import ru.skillbranch.sbdelivery.domain.auth.gateway.LogoutGateway
import ru.skillbranch.sbdelivery.domain.auth.usecases.*
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway
import ru.skillbranch.sbdelivery.domain.dashboard.usecases.GetDashboardModelUseCases
import ru.skillbranch.sbdelivery.domain.dish.gateways.DishGateway
import ru.skillbranch.sbdelivery.domain.dish.usecases.GetReviewsForDishUseCase
import ru.skillbranch.sbdelivery.domain.dish.usecases.SendReviewForDishUseCase
import ru.skillbranch.sbdelivery.domain.menu.gateways.MenuGateway
import ru.skillbranch.sbdelivery.domain.menu.usecases.GetMenuUseCases
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
    fun provideIsUserAuthorizedSingleUseCase(loginGateway: LoginGateway) =
        IsUserAuthorizedSingleUseCase(
            gateway = loginGateway
        )

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
    fun provideRegisterUseCases(loginGateway: LoginGateway) =
        RegisterUseCases(gateway = loginGateway)

    @Provides
    fun provideRecoveryFirstStepUseCase(loginGateway: LoginGateway) =
        RecoveryFirstStepUseCase(gateway = loginGateway)

    @Provides
    fun provideRecoverySecondStepUseCase(loginGateway: LoginGateway) =
        RecoverySecondStepUseCase(gateway = loginGateway)

    @Provides
    fun provideRecoveryThirdStepUseCase(loginGateway: LoginGateway) =
        RecoveryThirdStepUseCase(gateway = loginGateway)

    @Provides
    fun provideGetMenuUseCases(gateway: MenuGateway) =
        GetMenuUseCases(gateway = gateway)

    @Provides
    fun provideGetReviewsForDishUseCase(gateway: DishGateway) =
        GetReviewsForDishUseCase(dishGateway = gateway)

    @Provides
    fun provideSendReviewForDishUseCase(gateway: DishGateway) =
        SendReviewForDishUseCase(dishGateway = gateway)
}