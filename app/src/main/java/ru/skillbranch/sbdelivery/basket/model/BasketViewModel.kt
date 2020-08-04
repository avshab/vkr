package ru.skillbranch.sbdelivery.basket.model

import androidx.lifecycle.MutableLiveData
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModelWithState
import ru.skillbranch.sbdelivery.domain.auth.usecases.IsUserAuthorizedUseCase
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers

/**
 * Created by Anna Shabaeva on 28.07.2020
 */

class BasketViewModel(
    private val schedulers: Schedulers,
    private val isUserAuthorizedUseCase: IsUserAuthorizedUseCase
) : BaseViewModelWithState() {

    private val authStateDelegate = MutableLiveData<Boolean>()
    val authStateLiveData = authStateDelegate.asLiveData

}