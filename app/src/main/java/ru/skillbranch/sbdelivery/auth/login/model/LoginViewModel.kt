package ru.skillbranch.sbdelivery.auth.login.model

import androidx.lifecycle.MutableLiveData
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.domain.auth.usecases.LoginUseCases
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull
import ru.skillbranch.sbdelivery.utils.livedata.asLiveData
import ru.skillbranch.sbdelivery.utils.viewModel.BehaviorState

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginViewModel(private val schedulers: Schedulers, private val loginUseCases: LoginUseCases) :
    BaseViewModel() {

    val userEmailInputState = BehaviorState(EMPTY_STRING)
    val userPasswordInputState = BehaviorState(EMPTY_STRING)

    private val stateMutableLiveData = MutableLiveData<ViewModelState>()
    val stateLiveData = stateMutableLiveData.asLiveData

    fun debugLogin() {
        loginUseCases.build(email = "rad@yandex.com", password = "Test12345")
            .subscribeOn(schedulers.io()).observeOn(schedulers.ui()).subscribe( {
                stateMutableLiveData.value = ViewModelState.Success(emptyList())
            }, {
                stateMutableLiveData.value = ViewModelState.Error(it.message.defaultIfNull)
            }).untilCleared()
    }

    fun login() {
        loginUseCases.build(email = userEmailInputState.value, password = userPasswordInputState.value)
            .subscribeOn(schedulers.io()).observeOn(schedulers.ui()).subscribe( {
                stateMutableLiveData.value = ViewModelState.Success(emptyList())
            }, {
                stateMutableLiveData.value = ViewModelState.Error(it.message.defaultIfNull)
            }).untilCleared()
    }


}