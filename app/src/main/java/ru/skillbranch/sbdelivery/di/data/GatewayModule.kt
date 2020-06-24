package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.dashboard.api.DashboardApiService
import ru.skillbranch.sbdelivery.data.dashboard.gateways.DashboardGatewayImpl
import ru.skillbranch.sbdelivery.data.dashboard.mappers.DishesListResponseMapper
import ru.skillbranch.sbdelivery.data.dashboard.mappers.IdsResponseMapper
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

@Module
class GatewayModule {

    @Provides
    fun provideDashboardGateway(
        apiService: DashboardApiService,
        dishesMapper: DishesListResponseMapper,
        idsMapper: IdsResponseMapper
    ): DashboardGateway = DashboardGatewayImpl(
        apiService = apiService,
        dishesMapper = dishesMapper,
        idsMapper = idsMapper
    )
}