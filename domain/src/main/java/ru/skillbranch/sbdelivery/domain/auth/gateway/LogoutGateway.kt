package ru.skillbranch.sbdelivery.domain.auth.gateway

import io.reactivex.Completable

/**
 * Created by Anna Shabaeva on 02.07.2020
 */

interface LogoutGateway {

    fun logoutUser(): Completable

}