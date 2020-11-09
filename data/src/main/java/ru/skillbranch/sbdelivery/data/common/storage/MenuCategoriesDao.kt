package ru.skillbranch.sbdelivery.data.common.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.common.model.MenuCategoriesDbDto
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 09.11.2020
 */


@Dao
abstract class MenuCategoriesDao :
    MenuCategoriesStorage {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun put(value: List<MenuCategoriesDbDto>)

    override fun delete(): Completable {
        return Completable.fromCallable(::deleteCategory)
    }

    override fun get(): List<MenuCategoriesDbDto> {
        return getNullable() ?: emptyList()
    }

    override fun getSingle(): Single<List<MenuCategoriesDbDto>> {
        return Single.fromCallable {
            getNullable() ?: emptyList()
        }
    }

    @Query("DELETE FROM menuCategories")
    abstract fun deleteCategory()

    @Query("SELECT * FROM menuCategories")
    abstract fun getNullable(): List<MenuCategoriesDbDto>?

}