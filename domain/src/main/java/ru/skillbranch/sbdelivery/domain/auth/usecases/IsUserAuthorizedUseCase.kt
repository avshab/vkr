package ru.skillbranch.sbdelivery.domain.auth.usecases

import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway

class IsUserAuthorizedUseCase (
    private val gateway: LoginGateway
) {

    fun buildSingle(): Boolean = gateway.isUserAuthorized()

}