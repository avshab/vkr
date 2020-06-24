package ru.skillbranch.sbdelivery.domain.dashboard.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.dashboard.model.IDS

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

interface DashboardGateway {
    fun getDishes(): Single<List<DishModel>>

    fun getRecommendedDishesIds(): Single<List<IDS>>
}