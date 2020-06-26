package ru.skillbranch.sbdelivery.data.auth.api

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Anna Shabaeva on 26.06.2020
 */

interface AuthApiService {

    @POST("auth/login")
    fun login(
        @Body body: LoginRequestBody
    ): Single<Any>

}

class LoginRequestBody(

    @SerializedName("email")
    val email: String,

    @SerializedName("password")
    val password: String
)