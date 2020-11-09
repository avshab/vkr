package ru.skillbranch.sbdelivery.domain.launch.usecases

import io.reactivex.rxkotlin.Singles
import ru.skillbranch.sbdelivery.domain.launch.gateways.LaunchGateway

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

class LaunchUseCases(private val gateway: LaunchGateway) {

    fun buildSingle () = Singles.zip(
        gateway.loadMenuCategories(),
        gateway.loadDishes()
    )
}