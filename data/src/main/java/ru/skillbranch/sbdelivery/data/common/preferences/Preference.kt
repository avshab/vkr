package ru.skillbranch.sbdelivery.data.common.preferences

import io.reactivex.Observable

interface Preference<T> {

    var value: T

    val key: String

    val defaultValue: T

    val observable: Observable<T>


    fun delete()

    fun isSet(): Boolean

}