package ru.skillbranch.sbdelivery.data.auth.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.auth.api.AuthApiService
import ru.skillbranch.sbdelivery.data.auth.api.LoginRequestBody
import ru.skillbranch.sbdelivery.domain.auth.login.AuthGateway

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class AuthGatewayImpl(private val authApiService: AuthApiService) : AuthGateway {
    override fun login(email: String, password: String): Single<Any> {
        return authApiService.login(LoginRequestBody(email, password))
    }
}