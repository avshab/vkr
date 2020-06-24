package ru.skillbranch.sbdelivery.utils.rx

import io.reactivex.disposables.Disposable

/**
 * Created by Anna Shabaeva on 07.06.2020
 */


fun Disposable.disposeSafely() {
    if (!isDisposed) {
        dispose()
    }
}