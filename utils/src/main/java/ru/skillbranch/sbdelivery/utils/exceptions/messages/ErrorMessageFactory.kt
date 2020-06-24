package ru.skillbranch.sbdelivery.utils.exceptions.messages

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

interface ErrorMessageFactory {

    fun buildErrorMessage(exception: Throwable): String

}