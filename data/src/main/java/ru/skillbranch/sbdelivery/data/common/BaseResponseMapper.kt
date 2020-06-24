package ru.skillbranch.sbdelivery.data.common

import retrofit2.Response
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull

/**
 * Created by Anna Shabaeva on 07.06.2020
 */


abstract class BaseResponseMapper<R : BaseResponseBody, T : Any>(
    private val errorBodyConverter: ResponseErrorBodyConverter

) {

    fun map(response: Response<R>): T? {
        val result = if (response.isSuccessful && response.body() != null) {

            @Suppress("UNCHECKED_CAST")
            val body = response.body() as R
            if (body.isError.defaultIfNull) {
                val errorBody = errorBodyConverter.getErrorBodyFromResponseBody(body)
                mapError(errorBody)
            } else {
                mapResult(body)
            }

        } else {
            errorBodyConverter
                .getConvertedErrorBody(response.errorBody())
                ?.let(::mapError)
        }

        return result
    }

    protected abstract fun mapResult(responseBody: R): T

    protected open fun mapError(errorBody: BaseErrorResponseBody): T {
        throw IllegalStateException("Server returned unhandled error body. Check response logs")
    }

}