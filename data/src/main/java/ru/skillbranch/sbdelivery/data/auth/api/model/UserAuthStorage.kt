package ru.skillbranch.sbdelivery.data.auth.api.model

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

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