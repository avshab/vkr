package ru.skillbranch.sbdelivery.domain.auth.usecases

import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.auth.model.AuthModel
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginUseCases(private val gateway: LoginGateway) {

    fun build(email: String, password: String): Single<AuthModel> {
        return gateway.login(email = email, password = password)
            .map {
                AuthModel(accessToken = it.accessToken, refreshToken = it.refreshToken)
            }
    }
}