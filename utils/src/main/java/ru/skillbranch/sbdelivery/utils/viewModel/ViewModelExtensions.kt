package ru.skillbranch.sbdelivery.utils.viewModel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

inline fun <reified VM : ViewModel> Fragment.createViewModel(
    crossinline provider: () -> VM
): VM {
    return ViewModelProviders
        .of(this, BaseViewModelFactory { provider() })
        .get(VM::class.java)
}