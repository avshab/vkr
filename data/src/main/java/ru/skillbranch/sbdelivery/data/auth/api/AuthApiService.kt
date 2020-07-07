package ru.skillbranch.sbdelivery.data.auth.api

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import ru.skillbranch.sbdelivery.data.auth.model.LoginResultResponseBody
import retrofit2.Response
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

}

