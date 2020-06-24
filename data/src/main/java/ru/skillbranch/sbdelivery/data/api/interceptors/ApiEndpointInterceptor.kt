package ru.skillbranch.sbdelivery.data.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Anna Shabaeva on 05.06.2020
 */

class ApiEndpointInterceptor : Interceptor {

    companion object {
        val URL = "polls.apiblueprint.org"
    }

    override fun intercept(chain: Interceptor.Chain): Response = chain.proceed(chain.request().newBuilder().url(URL).build())

}