package ru.skillbranch.sbdelivery.domain.auth.login

import io.reactivex.Single

/**
 * Created by Anna Shabaeva on 01.07.2020
 */
class IsUserAuthorizedUseCase (
    private val gateway: AuthGateway
) {

    fun buildSingle(): Single<Boolean> = gateway.isUserAuthorized()

}