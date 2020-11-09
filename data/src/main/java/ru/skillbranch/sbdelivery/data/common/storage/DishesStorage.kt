package ru.skillbranch.sbdelivery.data.common.storage

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.common.model.DishesDbDto

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

interface DishesStorage {

    fun get(): List<DishesDbDto>

    fun delete(): Completable

    fun put(value: List<DishesDbDto>)

    fun getSingle(): Single<List<DishesDbDto>>
}
