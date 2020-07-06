package ru.skillbranch.sbdelivery.auth.registration.view

import android.os.Bundle
import android.view.View
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.auth.registration.model.RegistrationViewModel
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 26.06.2020
 */

class RegistrationFragment :  BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_registration

    @Inject lateinit var viewModel: RegistrationViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}