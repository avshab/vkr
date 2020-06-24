package ru.skillbranch.sbdelivery.utils.rx

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Anna Shabaeva on 18.06.2020
 */

class SchedulersImpl : ru.skillbranch.sbdelivery.utils.rx.Schedulers {

    override fun io(): Scheduler = Schedulers.io()

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

}