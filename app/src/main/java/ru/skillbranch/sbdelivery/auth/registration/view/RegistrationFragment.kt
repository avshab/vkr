package ru.skillbranch.sbdelivery.auth.registration.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_registration.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.registration.model.RegistrationViewModel
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.utils.extensions.onClick
import ru.skillbranch.sbdelivery.utils.extensions.onTextChange
import ru.skillbranch.sbdelivery.utils.text.hideError
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 26.06.2020
 */

class RegistrationFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_registration

    @Inject lateinit var viewModel: RegistrationViewModel

    override val toolbarVisibility = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSecondToolBar(getString(R.string.registration_title))

        setupInputViews()

        registrationButton.onClick(viewModel::register)

        enterButton.onClick { navController.navigateUp() }

        viewModel.stateLiveData.observe(::handleState)
    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> navController.navigate(R.id.dashboardFragment)
        }
    }

    private fun setupInputViews() {
        nameInputEditText.onTextChange { userName ->
            viewModel.nameInputState.accept(userName)
            nameInputLayout.hideError()
        }

        surnameInputEditText.onTextChange { userSurname ->
            viewModel.surnameInputState.accept(userSurname)
            surnameInputLayout.hideError()
        }

        emailInputEditText.onTextChange { email ->
            viewModel.userEmailInputState.accept(email)
            emailInputLayout.hideError()
        }

        passwordInputEditText.onTextChange { password ->
            viewModel.userPasswordInputState.accept(password)
            passwordInputLayout.hideError()
        }
    }
}