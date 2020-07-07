package ru.skillbranch.sbdelivery.auth.recovery.step1.view

import android.os.Bundle
import android.view.View
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.recovery.step1.model.RecoveryFirstStepViewModel
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 07.07.2020
 */
class RecoveryFirstStepFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_password_recovery_step_1

    @Inject lateinit var viewModel: RecoveryFirstStepViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSecondToolBar(getString(R.string.password_title))

    }
}