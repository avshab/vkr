package ru.skillbranch.sbdelivery.domain.auth.usecases

import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway

/**
 * Created by Anna Shabaeva on 01.07.2020
 */
class IsUserAuthorizedSingleUseCase (
    private val gateway: LoginGateway
) {

    fun buildSingle(): Single<Boolean> = gateway.isUserAuthorizedSingle()

}

