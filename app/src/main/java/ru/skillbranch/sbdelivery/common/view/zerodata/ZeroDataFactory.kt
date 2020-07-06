package ru.skillbranch.sbdelivery.common.view.zerodata

/**
 * Created by Anna Shabaeva on 05.07.2020
 */

interface ZeroDataFactory {

    fun buildZeroDataCell(): ZeroDataCell

    fun buildZeroDataErrorCell(error: Throwable): ZeroDataCell
}