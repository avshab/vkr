package ru.skillbranch.sbdelivery.utils.extensions

import android.text.Spannable
import android.text.style.CharacterStyle
import androidx.core.text.toSpannable

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

fun CharSequence.setSpanExclusive(span: CharacterStyle, from: Int, to: Int): Spannable {
    return this.toSpannable().apply {
        setSpan(span, from, to, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}