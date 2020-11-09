package ru.skillbranch.sbdelivery.launch.model

import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.disposables.Disposable
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.domain.auth.usecases.IsUserAuthorizedSingleUseCase
import ru.skillbranch.sbdelivery.domain.launch.usecases.LaunchUseCases
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import java.util.concurrent.TimeUnit

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

class LaunchViewModel(
    schedulers: Schedulers,
    isUserAuthorizedSingleUseCase: IsUserAuthorizedSingleUseCase,
    launchUseCases: LaunchUseCases
) : BaseViewModel() {
    //    private var authDisposable: Disposable? = null
//
    private val stateDelegate = MutableLiveData<Boolean>()
    val stateLiveData = stateDelegate.asLiveData
    private var disposable: Disposable? = null

    init {
//        disposable?.dispose()
//        disposable =
//            Single
//                .timer(3L, TimeUnit.SECONDS)
//                .subscribeOn(schedulers.io())
//                .observeOn(schedulers.ui())
//                .map { true }
//                .subscribe(stateDelegate::setValue)
//                .untilCleared()

        disposable?.dispose()
        disposable = launchUseCases.buildSingle()
                .subscribeOn(schedulers.io())
                .observeOn(schedulers.ui())
                .map { true }
                .subscribe(stateDelegate::setValue)
                .untilCleared()
//        authDisposable?.dispose()
//        authDisposable = isUserAuthorizedUseCase.buildSingle().subscribeOn(schedulers.io())
//            .observeOn(schedulers.ui()).subscribe(authStateDelegate::setValue).untilCleared()
    }
}