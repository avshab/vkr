package ru.skillbranch.sbdelivery.data.common.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.common.model.DishesDbDto

/**
 * Created by Anna Shabaeva on 09.11.2020
 */


@Dao
abstract class DishesDao :
    DishesStorage {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun put(value: List<DishesDbDto>)

    override fun delete(): Completable {
        return Completable.fromCallable(::deleteCategory)
    }

    override fun get(): List<DishesDbDto> {
        return getNullable() ?: emptyList()
    }

    override fun getSingle(): Single<List<DishesDbDto>> {
        return Single.fromCallable {
            getNullable() ?: emptyList()
        }
    }

    @Query("DELETE FROM dishList")
    abstract fun deleteCategory()

    @Query("SELECT * FROM dishList")
    abstract fun getNullable(): List<DishesDbDto>?

}