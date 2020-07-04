package ru.skillbranch.sbdelivery.domain.profile.usecases

import ru.skillbranch.sbdelivery.domain.profile.gateways.ProfileGateway

/**
 * Created by Anna Shabaeva on 03.07.2020
 */
class GetAndUpdateProfileUseCases(private val gateway: ProfileGateway) {

    fun build() = gateway.getAndUpdateProfile()
}