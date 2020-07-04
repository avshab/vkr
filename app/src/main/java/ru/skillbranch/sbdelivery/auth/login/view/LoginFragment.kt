package ru.skillbranch.sbdelivery.auth.login.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_login.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.login.model.LoginViewModel
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.utils.extensions.onClick
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 26.06.2020
 */
class LoginFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_login

    @Inject lateinit var viewModel: LoginViewModel

    override val toolbarVisibility = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginButton.onClick (viewModel::debugLogin)

        viewModel.stateLiveData.observe(::handleState)

    }

    fun handleState(state: ViewModelState) {
        when(state) {
            is ViewModelState.Success -> navController.navigateUp()
        }
    }
}