package ru.skillbranch.sbdelivery.launch.model

import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.domain.auth.login.IsUserAuthorizedUseCase
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

class LaunchViewModel(
    schedulers: Schedulers,
    isUserAuthorizedUseCase: IsUserAuthorizedUseCase
) : BaseViewModel() {
    private var authDisposable: Disposable? = null

    private val authStateDelegate = MutableLiveData<Boolean>()
    val authStateLiveData = authStateDelegate.asLiveData


    init {
        authDisposable?.dispose()
        authDisposable = isUserAuthorizedUseCase.buildSingle().subscribeOn(schedulers.io())
            .observeOn(schedulers.ui()).subscribe(authStateDelegate::setValue).untilCleared()
    }
}