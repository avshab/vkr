package ru.skillbranch.sbdelivery.utils.text

import android.text.Editable
import android.text.TextWatcher

open class InputWatcher : TextWatcher {

    override fun afterTextChanged(editable: Editable) = Unit

    override fun onTextChanged(
        charSequence: CharSequence,
        start: Int,
        before: Int,
        count: Int
    ) = Unit

    override fun beforeTextChanged(
        charSequence: CharSequence,
        start: Int,
        count: Int,
        after: Int
    ) = Unit

}