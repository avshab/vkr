package ru.skillbranch.sbdelivery.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * Created by Anna Shabaeva on 03.07.2020
 */
fun Context.shortToast(text: String, bottomMargin: Float = 0.0f) {
    Toast
        .makeText(this, text, Toast.LENGTH_SHORT)
        .apply {
            setMargin(0.0f, bottomMargin)
        }
        .show()
}

fun Fragment.shortToast(text: String, bottomMargin: Float = 0.0f) {
    context?.shortToast(text, bottomMargin)
}

fun Activity.shortToast(text: String, bottomMargin: Float = 0.0f) {
    this.shortToast(text, bottomMargin)
}
