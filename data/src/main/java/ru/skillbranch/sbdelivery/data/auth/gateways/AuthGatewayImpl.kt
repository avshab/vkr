package ru.skillbranch.sbdelivery.data.auth.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.auth.api.AuthApiService
import ru.skillbranch.sbdelivery.data.auth.api.LoginRequestBody
import ru.skillbranch.sbdelivery.domain.auth.login.AuthGateway
import ru.skillbranch.sbdelivery.domain.auth.login.LoginModel
import ru.skillbranch.sbdelivery.data.auth.api.model.UserAuthDbDto
import ru.skillbranch.sbdelivery.data.auth.api.model.UserAuthStorage

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class AuthGatewayImpl(private val authApiService: AuthApiService,
                      private val userAuthStorage: UserAuthStorage
) : AuthGateway {
    override fun login(email: String, password: String): Single<LoginModel> {
        return authApiService.login(LoginRequestBody(email, password)).map {
            LoginModel(
                accessToken = it.accessToken,
                refreshToken = it.refreshToken
            )
        }.doOnSuccess(::saveUserAuth)
    }

    private fun saveUserAuth(loginResult: LoginModel) {
        with(loginResult) {
            val dbDto =
                UserAuthDbDto(
                    accessToken,
                    refreshToken
                )
            userAuthStorage.put(dbDto)
        }
    }

    override fun getUserAuth(): Single<LoginModel> {
        return userAuthStorage
            .getSingle()
            .map(::buildUserAuthModel)
    }

    private fun buildUserAuthModel(dto: UserAuthDbDto): LoginModel {
        return LoginModel(
            accessToken = dto.accessToken,
            refreshToken = dto.refreshToken
        )
    }

    override fun isUserAuthorized(): Single<Boolean> {
        return userAuthStorage
            .getSingle()
            .map(UserAuthDbDto::isNotEmpty)
    }
}