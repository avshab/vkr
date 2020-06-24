package ru.skillbranch.sbdelivery.common.viewModel

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.utils.rx.disposeSafely

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

abstract class BaseViewModel : ViewModel() {

    private val onClearedDisposable = CompositeDisposable()

    @CallSuper
    override fun onCleared() {
        onClearedDisposable.disposeSafely()
    }

    fun Disposable.untilCleared(): Disposable = this.apply { onClearedDisposable.add(this) }

}