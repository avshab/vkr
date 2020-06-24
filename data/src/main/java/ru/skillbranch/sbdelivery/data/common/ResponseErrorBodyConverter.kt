package ru.skillbranch.sbdelivery.data.common

import okhttp3.ResponseBody
import retrofit2.Retrofit

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class ResponseErrorBodyConverter(
    private val retrofit: Retrofit
) {

    fun getConvertedErrorBody(errorBody: ResponseBody?): BaseErrorResponseBody? {
        if (errorBody == null) {
            return null
        }
        return retrofit
            .responseBodyConverter<BaseErrorResponseBody>(
                BaseErrorResponseBody::class.java,
                BaseErrorResponseBody::class.java.annotations
            )
            .convert(errorBody)
    }

    fun getErrorBodyFromResponseBody(responseBody: BaseResponseBody): BaseErrorResponseBody {
        return BaseErrorResponseBody(
           // apiVersion = responseBody.apiVersion,
            errorCode = responseBody.errorCode,
            errorMessage = responseBody.message
        )
    }
}