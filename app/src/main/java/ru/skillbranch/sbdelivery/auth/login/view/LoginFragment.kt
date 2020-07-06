package ru.skillbranch.sbdelivery.auth.login.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_login.emailInputEditText
import kotlinx.android.synthetic.main.fragment_login.emailInputLayout
import kotlinx.android.synthetic.main.fragment_login.loginButton
import kotlinx.android.synthetic.main.fragment_login.passwordInputEditText
import kotlinx.android.synthetic.main.fragment_login.passwordInputLayout
import kotlinx.android.synthetic.main.fragment_login.registrationButton
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.login.model.LoginViewModel
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.utils.extensions.onClick
import ru.skillbranch.sbdelivery.utils.extensions.onTextChange
import ru.skillbranch.sbdelivery.utils.text.hideError
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

        setupSecondToolBar(getString(R.string.login_title))

        setupInputViews()

        loginButton.onClick (viewModel::debugLogin)

        viewModel.stateLiveData.observe(::handleState)

        registrationButton.onClick {
            navController.navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

    private fun setupInputViews() {
        emailInputEditText.onTextChange { email ->
            viewModel.userEmailInputState.accept(email)
            emailInputLayout.hideError()
        }

        passwordInputEditText.onTextChange { password ->
            viewModel.userPasswordInputState.accept(password)
            passwordInputLayout.hideError()
        }
    }

    private fun handleState(state: ViewModelState) {
        when(state) {
            is ViewModelState.Success -> navController.navigateUp()
        }
    }
}