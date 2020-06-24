package ru.skillbranch.sbdelivery.utils.exceptions

import java.util.*

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

const val DEFAULT_INT = -1

const val DEFAULT_LONG = -1L

const val DEFAULT_DOUBLE = -1.0

const val EMPTY_STRING: String = ""

const val EMPTY_CHAR = ' '

const val WHITESPACE: String = " "

const val LINE_BREAK: String = "\n"

const val RUB_SYMBOL: String = "\u20BD"

val DEFAULT_DATE = Date(DEFAULT_LONG)

val Int?.defaultIfNull: Int get() = this ?: DEFAULT_INT

val Boolean?.defaultIfNull: Boolean get() = this ?: false

val Long?.defaultIfNull: Long get() = this ?: DEFAULT_LONG

val String?.defaultIfNull: String get() = this ?: EMPTY_STRING

val Double?.defaultIfNull: Double get() = this ?: DEFAULT_DOUBLE

val <T> List<T>?.defaultIfNull: List<T> get() = this ?: emptyList()

val IntArray?.defaultIfNull: IntArray get() = this ?: intArrayOf()
