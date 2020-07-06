package ru.skillbranch.sbdelivery.domain.auth.usecases

import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
import ru.skillbranch.sbdelivery.domain.auth.model.AuthModel

/**
 * Created by Anna Shabaeva on 06.07.2020
 */
class RegisterUseCases(private val gateway: LoginGateway) {
    fun build(name: String, surname: String, email: String, password: String): Single<AuthModel> {
        return gateway.register(name = name, surname = surname, email = email, password = password)
            .map {
                AuthModel(accessToken = it.accessToken, refreshToken = it.refreshToken)
            }
    }
}