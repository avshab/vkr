package ru.skillbranch.sbdelivery.data.auth.gateways

import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.auth.api.AuthApiService
import ru.skillbranch.sbdelivery.data.auth.api.LoginRequestBody
import ru.skillbranch.sbdelivery.data.auth.api.RegisterRequestBody
import ru.skillbranch.sbdelivery.domain.auth.gateway.LoginGateway
import ru.skillbranch.sbdelivery.domain.auth.model.AuthModel
import ru.skillbranch.sbdelivery.data.auth.model.UserAuthDbDto
import ru.skillbranch.sbdelivery.data.auth.storage.UserAuthStorage
import ru.skillbranch.sbdelivery.data.common.userData.UserDataStorage
import ru.skillbranch.sbdelivery.domain.auth.model.LoginModel
import ru.skillbranch.sbdelivery.domain.userData.model.UserDataModel

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginGatewayImpl(
    private val authApiService: AuthApiService,
    private val userAuthStorage: UserAuthStorage,
    private val userDataStorage: UserDataStorage
) : LoginGateway {

    override fun observeUserAuth(): Observable<AuthModel> {
        return userAuthStorage
            .getObservable()
            .map(::buildUserAuthModel)
    }

    override fun login(email: String, password: String): Single<LoginModel> {
        return authApiService.login(LoginRequestBody(email, password))
            .map {
                LoginModel(
                    id = it.id,
                    firstName = it.firstName,
                    lastName = it.lastName,
                    email = it.email,
                    accessToken = it.accessToken,
                    refreshToken = it.refreshToken
                )
            }
            .doOnSuccess(::saveUserAuth).doOnSuccess(::saveUserData)
    }

    override fun register(
        name: String,
        surname: String,
        email: String,
        password: String
    ): Single<LoginModel> {
        return authApiService.register(
            RegisterRequestBody(
                firstName = name,
                lastName = surname,
                email = email,
                password = password
            )
        ).map {
            LoginModel(
                id = it.id,
                firstName = it.firstName,
                lastName = it.lastName,
                email = it.email,
                accessToken = it.accessToken,
                refreshToken = it.refreshToken
            )
        }
            .doOnSuccess(::saveUserAuth).doOnSuccess(::saveUserData)
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

    private fun saveUserData(loginResult: LoginModel) {
        with(loginResult) {
            val userData = UserDataModel(
                id,
                firstName,
                lastName,
                email
            )
            userDataStorage.saveUserDataModel(userData)
        }
    }

    override fun getUserAuth(): Single<AuthModel> {
        return userAuthStorage
            .getSingle()
            .map(::buildUserAuthModel)
    }

    private fun buildUserAuthModel(dto: UserAuthDbDto): AuthModel {
        return AuthModel(
            accessToken = dto.accessToken,
            refreshToken = dto.refreshToken
        )
    }

    override fun isUserAuthorized(): Single<Boolean> {
        return userAuthStorage
            .getSingle()
            .map(UserAuthDbDto::isNotEmpty)
    }


//    override fun refreshUserAuth(): Single<LoginModel> {
//        return userAuthStorage
//            .getSingle()
//            .map { auth ->
//                RefreshAuthRequestBody(
//                    auth.accessToken,
//                    auth.refreshToken
//                )
//            }
//            .flatMap(authApiService::refreshAuth)
//            .map(refreshAuthResponseMapper::map)
//            .unwrapOptionalOrThrow()
//            .doOnSuccess(::updateUserAuth)
//    }
}