package ru.skillbranch.sbdelivery.data.dashboard.gateways

import io.reactivex.Single
import retrofit2.Response
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.dashboard.api.DashboardApiService
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.dashboard.model.IDS
/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class DashboardGatewayImpl(
    private val apiService: DashboardApiService,
    private val mapper: BaseResponseMapper
) : DashboardGateway {

    override fun getDishes(): Single<List<DishModel>> {
        return apiService.getDishes().map {
            mapper.map(it as Response<Any?>) as? List<DishModel>
        }
    }

    override fun getRecommendedDishesIds(): Single<List<IDS>> {
        return apiService.getRecommend().map {
            mapper.map(it as Response<Any?>) as? List<IDS>
        }
    }
}