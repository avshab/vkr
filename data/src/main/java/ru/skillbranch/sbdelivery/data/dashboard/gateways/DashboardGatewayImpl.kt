package ru.skillbranch.sbdelivery.data.dashboard.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.dashboard.api.DashboardApiService
import ru.skillbranch.sbdelivery.data.dashboard.mappers.DishesListResponseMapper
import ru.skillbranch.sbdelivery.data.dashboard.mappers.IdsResponseMapper
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.dashboard.model.IDS
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class DashboardGatewayImpl(
    private val apiService: DashboardApiService,
    private val dishesMapper: DishesListResponseMapper,
    private val idsMapper: IdsResponseMapper
) : DashboardGateway {

    override fun getDishes(): Single<List<DishModel>> {
        return apiService.getDishes().map { it.defaultIfNull }
    }

    override fun getRecommendedDishesIds(): Single<List<IDS>> {
        return apiService.getRecommend().map { it.defaultIfNull }
    }
}