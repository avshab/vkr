package ru.skillbranch.sbdelivery.auth.recovery.step3.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_password_recovery_step_1.*
import kotlinx.android.synthetic.main.fragment_password_recovery_step_3.*
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.recovery.step3.model.RecoveryThirdStepViewModel
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.utils.extensions.arguments
import ru.skillbranch.sbdelivery.utils.extensions.onClick
import ru.skillbranch.sbdelivery.utils.extensions.onTextChange
import ru.skillbranch.sbdelivery.utils.text.hideError
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 07.07.2020
 */

class RecoveryThirdStepFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_password_recovery_step_3

    @Inject lateinit var viewModel: RecoveryThirdStepViewModel

    override val toolbarVisibility = false

    private val fragmentArgs by arguments<RecoveryThirdStepArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSecondToolBar(getString(R.string.password_title))

        setupInputViews()

        viewModel.stateLiveData.observe(::handleState)
    }

    private fun setupInputViews() {

        passwordInputEditText.onTextChange { password ->
            viewModel.passwordInputState.accept(password)
            passwordInputLayout.hideError()
        }

        repeatPasswordInputEditText.onTextChange { password ->
            viewModel.repeatPasswordInputState.accept(password)
            repeatPasswordInputLayout.hideError()
        }

        savePasswordButton.onClick(viewModel::saveData)

    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> {
                navController.navigate(R.id.dashboardFragment)
            }
        }
    }

}
