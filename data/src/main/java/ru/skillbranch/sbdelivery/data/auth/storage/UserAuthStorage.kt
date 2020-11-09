package ru.skillbranch.sbdelivery.data.auth.storage

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.data.auth.model.UserAuthDbDto

/**
 * Created by Anna Shabaeva on 28.06.2020
 */
interface UserAuthStorage {

    fun get(): UserAuthDbDto

    fun delete(): Completable

    fun put(value: UserAuthDbDto)

    fun getSingle(): Single<UserAuthDbDto>

    fun getObservable(): Observable<UserAuthDbDto>

}
