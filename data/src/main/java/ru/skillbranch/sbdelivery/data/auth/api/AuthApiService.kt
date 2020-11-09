package ru.skillbranch.sbdelivery.data.auth.api

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import ru.skillbranch.sbdelivery.data.auth.model.LoginResultResponseBody
import retrofit2.Response
import ru.skillbranch.sbdelivery.data.auth.model.RefreshAuthResponseBody

/**
 * Created by Anna Shabaeva on 26.06.2020
 */

interface AuthApiService {

    @POST("auth/login")
    fun login(
        @Body body: LoginRequestBody
    ): Single<Response<LoginResultResponseBody>>

    @POST("auth/register")
    fun register(
        @Body body: RegisterRequestBody
    ): Single<Response<LoginResultResponseBody>>

    @POST("auth/recovery/email")
    fun recoveryEmail(
        @Body body: RecoveryEmailBody
    ): Completable

    @POST("auth/recovery/code")
    fun recoveryCode(
        @Body body: RecoveryCodeBody
    ): Completable

    @POST("auth/recovery/password")
    fun recoveryPassword(
        @Body body: RecoveryPasswordBody
    ): Single<Response<Any>>

    @POST("auth/refresh")
    fun refresh(
        @Body body: RefreshAuthRequestBody
    ): Single<Response<RefreshAuthResponseBody>>
}

