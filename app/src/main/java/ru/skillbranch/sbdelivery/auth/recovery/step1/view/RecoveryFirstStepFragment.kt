package ru.skillbranch.sbdelivery.auth.recovery.step1.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_password_recovery_step_1.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.recovery.step1.model.RecoveryFirstStepViewModel
import ru.skillbranch.sbdelivery.auth.recovery.step2.view.RecoverySecondStepArgs
import ru.skillbranch.sbdelivery.auth.recovery.step2.view.RecoverySecondStepFragment
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.utils.extensions.onClick
import ru.skillbranch.sbdelivery.utils.extensions.onTextChange
import ru.skillbranch.sbdelivery.utils.extensions.toBundle
import ru.skillbranch.sbdelivery.utils.text.hideError
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 07.07.2020
 */
class RecoveryFirstStepFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_password_recovery_step_1

    @Inject lateinit var viewModel: RecoveryFirstStepViewModel

    override val toolbarVisibility = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSecondToolBar(getString(R.string.password_title))

        setupInputViews()

        viewModel.stateLiveData.observe(::handleState)
    }

    private fun setupInputViews() {
        emailInputEditText.onTextChange { email ->
            viewModel.userEmailInputState.accept(email)
            emailInputLayout.hideError()
        }

        sendButton.onClick(viewModel::sendEmail)
    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> {
                val args = RecoverySecondStepArgs(email = viewModel.userEmailInputState.value)
                navController.navigate(
                    R.id.recoverySecondStepFragment,
                    args.toBundle<RecoverySecondStepFragment>()
                )
            }
        }
    }
}