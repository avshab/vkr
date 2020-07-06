package ru.skillbranch.sbdelivery.data.auth.util

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class ModifiedInterceptor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        Log.i("--TAG",  "MODIFIED_SINCE 0")
        return chain.proceed(
            request
                .newBuilder()
                .addHeader(
                    MODIFIED_SINCE, "0"
                ).build()
        )
    }
}