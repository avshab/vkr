package ru.skillbranch.sbdelivery.di.domain

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway
import ru.skillbranch.sbdelivery.domain.dashboard.usecases.GetDashboardModelUseCases

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class UseCasesModule {

    @Provides
    fun provideGetDashboardModelUseCases(dashboardGateway: DashboardGateway) =
        GetDashboardModelUseCases(dashboardGateway = dashboardGateway)

}