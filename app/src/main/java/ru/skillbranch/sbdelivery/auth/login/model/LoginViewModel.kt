package ru.skillbranch.sbdelivery.auth.login.model

import android.util.Log
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.common.viewModel.BaseViewModel
import ru.skillbranch.sbdelivery.domain.auth.login.LoginUseCases

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginViewModel(private val schedulers: Schedulers, private val loginUseCases: LoginUseCases) :
    BaseViewModel() {

    init {

        loginUseCases.build(email = "rad@yandex.com", password = "Test12345")
            .subscribeOn(schedulers.io()).observeOn(schedulers.ui()).subscribe( {
                Log.i("--TAG", it.toString())
            }, {
                Log.i("--TAG-TROWABLE", it.toString())

            }).untilCleared()
    }



}