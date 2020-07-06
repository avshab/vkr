package ru.skillbranch.sbdelivery.data.common.api

import retrofit2.Response
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull

/**
 * Created by Anna Shabaeva on 07.06.2020
 */


class BaseResponseMapper(
    private val errorBodyConverter: ResponseErrorBodyConverter
) {

    fun map(response: Response<Any?>): Any? {
        val result = if (response.isSuccessful && response.body() != null) {

            @Suppress("UNCHECKED_CAST")
            val body = response.body() as BaseResponseBody
            if (body.isError.defaultIfNull) {
                val errorBody = errorBodyConverter.getErrorBodyFromResponseBody(body)
                mapError(errorBody)
            } else {
               body
            }

        } else {
            errorBodyConverter
                .getConvertedErrorBody(response.errorBody())
                ?.let(::mapError)
        }

        return result
    }

    private fun mapError(errorBody: BaseErrorResponseBody): Any {
        throw IllegalStateException("Server returned unhandled error body. Check response logs")
    }

}