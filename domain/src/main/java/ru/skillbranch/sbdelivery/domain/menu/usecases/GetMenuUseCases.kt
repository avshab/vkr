package ru.skillbranch.sbdelivery.domain.menu.usecases

import ru.skillbranch.sbdelivery.domain.menu.gateways.MenuGateway

/**
 * Created by Anna Shabaeva on 10.07.2020
 */
class GetMenuUseCases(private val gateway: MenuGateway) {

    fun buildSingle() = gateway.getCategorise()
}