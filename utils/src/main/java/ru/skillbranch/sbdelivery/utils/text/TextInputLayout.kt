package ru.skillbranch.sbdelivery.utils.text

import com.google.android.material.textfield.TextInputLayout
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING
import ru.skillbranch.sbdelivery.utils.exceptions.WHITESPACE
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone

/**
 * Created by Anna Shabaeva on 06.07.2020
 */

fun TextInputLayout.displayError(errorMessage: String = EMPTY_STRING) {

    fun changeVisibilityOfErrorLabel(isVisible: Boolean) {
        if (childCount == 2) {
            getChildAt(1).makeVisibleOrGone(isVisible)
        }
    }

    if (errorMessage.isNotBlank()) {
        error = errorMessage
        changeVisibilityOfErrorLabel(true)
    } else {
        error = WHITESPACE
        changeVisibilityOfErrorLabel(false)
    }
}

fun TextInputLayout.hideError() {
    error = null
}