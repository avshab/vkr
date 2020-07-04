package ru.skillbranch.sbdelivery.data.auth.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.auth.model.UserAuthDbDto

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

@Dao
abstract class UserAuthDao :
    UserAuthStorage {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun put(value: UserAuthDbDto)

    override fun delete(): Completable {
        return Completable.fromCallable(::deleteAuth)
    }

    override fun get(): UserAuthDbDto {
        return getNullableAuth() ?: UserAuthDbDto.EMPTY
    }

    override fun getSingle(): Single<UserAuthDbDto> {
        return Single.fromCallable {
            getNullableAuth() ?: UserAuthDbDto.EMPTY
        }
    }

    override fun getObservable(): Observable<UserAuthDbDto> {
        return getListObservable().map { tokens ->
            tokens.firstOrNull() ?: UserAuthDbDto.EMPTY
        }
    }

    @Query("DELETE FROM auth")
    abstract fun deleteAuth()

    @Query("SELECT * FROM auth LIMIT 1")
    abstract fun getNullableAuth(): UserAuthDbDto?

    @Query("SELECT * FROM auth LIMIT 1")
    abstract fun getListObservable(): Observable<List<UserAuthDbDto>>

}