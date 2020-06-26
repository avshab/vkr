package ru.skillbranch.sbdelivery.auth.login.view

import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.login.model.LoginViewModel
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_login

    @Inject lateinit var viewModel: LoginViewModel
}