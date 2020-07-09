package ru.skillbranch.sbdelivery.auth.recovery.step2.view

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_password_recovery_step_2.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.recovery.step2.model.RecoverySecondStepViewModel
import ru.skillbranch.sbdelivery.auth.recovery.step3.view.RecoveryThirdStepArgs
import ru.skillbranch.sbdelivery.auth.recovery.step3.view.RecoveryThirdStepFragment
import ru.skillbranch.sbdelivery.common.viewModel.ViewModelState
import ru.skillbranch.sbdelivery.utils.extensions.arguments
import ru.skillbranch.sbdelivery.utils.extensions.onTextChange
import ru.skillbranch.sbdelivery.utils.extensions.toBundle
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 07.07.2020*/

class RecoverySecondStepFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_password_recovery_step_2

    @Inject lateinit var viewModel: RecoverySecondStepViewModel

    override val toolbarVisibility = false

    private val fragmentArgs by arguments<RecoverySecondStepArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSecondToolBar(getString(R.string.password_title))

        setupInputViews()

        viewModel.stateLiveData.observe(::handleState)

    }


    private fun setupInputViews() {
        box1EditText.onTextChange { txt ->
            viewModel.box1State.accept(txt)
        }

        box2EditText.onTextChange { txt ->
            viewModel.box2State.accept(txt)
        }

        box3EditText.onTextChange { txt ->
            viewModel.box3State.accept(txt)
        }

        box4EditText.onTextChange { txt ->
            viewModel.box4State.accept(txt)

            if (viewModel.box1State.value.isNullOrBlank() && viewModel.box2State.value.isNullOrBlank() && viewModel.box3State.value.isNullOrBlank())
                viewModel.sendCode()
        }

    }

    private fun handleState(state: ViewModelState) {
        when (state) {
            is ViewModelState.Success -> {
                val args = RecoveryThirdStepArgs(email = fragmentArgs.email, code = viewModel.code)
                navController.navigate(
                    R.id.recoveryThirdStepFragment,
                    args.toBundle<RecoveryThirdStepFragment>()
                )
            }
        }
    }
}