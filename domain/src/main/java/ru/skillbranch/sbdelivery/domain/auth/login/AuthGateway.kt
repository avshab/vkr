package ru.skillbranch.sbdelivery.domain.auth.login

import io.reactivex.Single

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
interface AuthGateway {

    fun login(email: String, password: String): Single<Any>

}