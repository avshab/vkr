package ru.skillbranch.sbdelivery.utils.viewModel

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable

/**
 * Created by Anna Shabaeva on 03.07.2020
 */

class BehaviorState<T>(defaultValue: T) {

    private val relay: BehaviorRelay<T> = BehaviorRelay.createDefault(defaultValue)

    val flowable: Flowable<T> = relay.toFlowable(BackpressureStrategy.DROP)

    val value: T get() = relay.value!!

    fun accept(value: T) = relay.accept(value)

}