package ru.skillbranch.sbdelivery.utils.extensions

import androidx.core.view.postDelayed
import androidx.fragment.app.Fragment

/**
 * Created by Anna Shabaeva on 25.06.2020
 */

inline fun Fragment.postDelayed(timeInMillis: Long, crossinline action: () -> Unit) {
    requireView().postDelayed(timeInMillis, action)
}