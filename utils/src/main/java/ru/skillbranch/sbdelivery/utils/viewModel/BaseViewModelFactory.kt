package ru.skillbranch.sbdelivery.utils.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class BaseViewModelFactory<T>(val creator: () -> T) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = creator() as T

}