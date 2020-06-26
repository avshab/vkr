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
        return Single.just(
            listOf(
                DishModel(73872634L, 123, "МАКАРОНЫ"),
                DishModel(72638L, 125, "КАртофан"),
                DishModel(6235462L, 213,"салат")
            )
        )//apiService.getDishes().map { it.defaultIfNull }
    }

    override fun getRecommendedDishesIds(): Single<List<IDS>> {
        return Single.just(listOf("13","23","24423","342"))//apiService.getRecommend().map { it.defaultIfNull }
    }
}