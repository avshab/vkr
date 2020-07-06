package ru.skillbranch.sbdelivery.common.viewModel

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.view.zerodata.DefaultZeroDataFactory
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.disposeSafely

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

abstract class BaseViewModel : ViewModel() {

    private val onClearedDisposable = CompositeDisposable()

    private val zeroDataFactory = DefaultZeroDataFactory()

    @CallSuper
    override fun onCleared() {
        onClearedDisposable.disposeSafely()
    }

    fun Disposable.untilCleared(): Disposable = this.apply { onClearedDisposable.add(this) }
}

abstract class BaseViewModelWithState : BaseViewModel() {

    private val zeroDataFactory = DefaultZeroDataFactory()

    protected val stateMutableLiveData = MutableLiveData<ViewModelState>()
    val stateLiveData = stateMutableLiveData.asLiveData


    protected fun handleError(throwable: Throwable) {
        Log.i("--TAG", "handleError")
        stateMutableLiveData.value = ViewModelState.Error(
            zeroCell = listOf(zeroDataFactory.buildZeroDataErrorCell(error = throwable)),
            message = throwable.message.defaultIfNull
        )
    }
}