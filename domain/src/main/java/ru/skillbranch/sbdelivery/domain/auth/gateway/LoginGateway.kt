package ru.skillbranch.sbdelivery.domain.auth.gateway

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.auth.model.AuthModel
import ru.skillbranch.sbdelivery.domain.auth.model.LoginModel

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
interface LoginGateway {

    fun observeUserAuth(): Observable<AuthModel>

    fun login(email: String, password: String): Single<LoginModel>

    fun register(name: String, surname: String, email: String, password: String): Single<LoginModel>

    fun getUserAuth(): Single<AuthModel>

    fun isUserAuthorizedSingle(): Single<Boolean>

    fun isUserAuthorized(): Boolean

    fun recoveryFirstStep(email: String): Completable

    fun recoverySecondStep(email: String, code: String): Completable

    fun recoveryThirdStep(email: String, code: String, password: String): Single<Any>

    fun refreshUserAuth(): Single<String>

}