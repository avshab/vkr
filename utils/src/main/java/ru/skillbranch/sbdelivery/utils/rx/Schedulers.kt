package ru.skillbranch.sbdelivery.utils.rx

import io.reactivex.Scheduler

/**
 * Created by Anna Shabaeva on 18.06.2020
 */
interface Schedulers {

    fun io(): Scheduler

    fun ui(): Scheduler
}