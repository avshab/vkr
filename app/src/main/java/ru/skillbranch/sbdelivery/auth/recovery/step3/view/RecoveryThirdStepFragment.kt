package ru.skillbranch.sbdelivery.auth.recovery.step3.view

import android.os.Bundle
import android.view.View
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.recovery.step3.model.RecoveryThirdStepViewModel
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 07.07.2020
 */

class RecoveryThirdStepFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_password_recovery_step_3

    @Inject lateinit var viewModel: RecoveryThirdStepViewModel

    override val toolbarVisibility = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSecondToolBar(getString(R.string.password_title))

    }
}
