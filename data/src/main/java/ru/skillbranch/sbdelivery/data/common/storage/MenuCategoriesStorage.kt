package ru.skillbranch.sbdelivery.data.common.storage

import io.reactivex.Completable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.common.model.MenuCategoriesDbDto

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

interface MenuCategoriesStorage {

    fun get(): List<MenuCategoriesDbDto>

    fun delete(): Completable

    fun put(value: List<MenuCategoriesDbDto>)

    fun getSingle(): Single<List<MenuCategoriesDbDto>>

}
