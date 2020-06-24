package ru.skillbranch.sbdelivery.domain.dashboard.usecases

import io.reactivex.Single
import io.reactivex.rxkotlin.Singles
import ru.skillbranch.sbdelivery.domain.dashboard.gateways.DashboardGateway
import ru.skillbranch.sbdelivery.domain.dashboard.model.DashboardModel

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class GetDashboardModelUseCases(
    private val dashboardGateway: DashboardGateway
) {
    fun buildSingle(): Single<DashboardModel> {
        return Singles.zip(
            dashboardGateway.getRecommendedDishesIds(),
            dashboardGateway.getDishes(),
            ::DashboardModel
        )
    }

}
