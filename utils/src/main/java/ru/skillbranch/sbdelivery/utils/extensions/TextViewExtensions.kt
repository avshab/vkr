package ru.skillbranch.sbdelivery.utils.extensions

import android.text.Editable
import android.widget.EditText
import android.widget.TextView
import ru.skillbranch.sbdelivery.utils.text.InputWatcher
import ru.skillbranch.sbdelivery.utils.exceptions.EMPTY_STRING

/**
 * Created by Anna Shabaeva on 06.07.2020
 */

val TextView?.textStr: String
    get() = this?.text?.toString() ?: EMPTY_STRING


fun EditText.onTextChange(
    action: (text: String) -> Unit
) {
    addTextChangedListener(object : InputWatcher() {
        override fun afterTextChanged(editable: Editable) = action(textStr)
    })
}

