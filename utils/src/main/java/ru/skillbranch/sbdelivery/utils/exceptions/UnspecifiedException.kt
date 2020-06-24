package ru.skillbranch.sbdelivery.utils.exceptions

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

class UnspecifiedException(
    throwable: Throwable? = null
) : IllegalStateException(throwable)