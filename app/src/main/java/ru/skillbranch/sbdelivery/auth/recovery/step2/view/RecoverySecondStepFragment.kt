package ru.skillbranch.sbdelivery.auth.recovery.step2.view

import android.os.Bundle
import android.view.View
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.recovery.step2.model.RecoverySecondStepViewModel
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 07.07.2020*/

class RecoverySecondStepFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_password_recovery_step_2

    @Inject lateinit var viewModel: RecoverySecondStepViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSecondToolBar(getString(R.string.password_title))

    }

}