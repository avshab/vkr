package ru.skillbranch.sbdelivery.domain.auth.login

import io.reactivex.Single

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginUseCases(private val gateway: AuthGateway) {

    fun build(email: String, password: String): Single<LoginModel> {
        return gateway.login(email = email, password = password)
    }
}