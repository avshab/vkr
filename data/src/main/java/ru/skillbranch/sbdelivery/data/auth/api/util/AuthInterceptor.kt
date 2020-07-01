package ru.skillbranch.sbdelivery.data.auth.api.util

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response
import ru.skillbranch.sbdelivery.domain.auth.login.AuthGateway
import ru.skillbranch.sbdelivery.domain.auth.login.LoginModel
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING

/**
 * Created by Anna Shabaeva on 01.07.2020
 */
class AuthInterceptor(private val loginGateway: AuthGateway) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        if (request.header(AUTH_HEADER_NAME) == SKIP_AUTH_TYPE) {
            return chain.proceed(request)
        }

        val accessToken = try {
            loginGateway
                .getUserAuth()
                .map(LoginModel::accessToken)
                .blockingGet()
        } catch (exc: Exception) {
            Log.e("--TAG_E", exc.message)
            EMPTY_STRING
        }

        if (accessToken.isBlank()) {
            return chain.proceed(request)
        }

        return chain.proceed(
            request
                .newBuilder()
                .addHeader(
                    AUTH_HEADER_NAME,
                    buildAuthHeaderValue(accessToken)
                )
                .build()
        )
    }

}

