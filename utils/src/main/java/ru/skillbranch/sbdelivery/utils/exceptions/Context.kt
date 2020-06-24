package ru.skillbranch.sbdelivery.utils.exceptions

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.TypedValue
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.FontRes
import androidx.annotation.IntegerRes
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

@SuppressLint("MissingPermission")
fun Context.getNetworkInfo(): NetworkInfo? {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return cm.activeNetworkInfo
}


fun Context.isConnected(): Boolean = getNetworkInfo()?.isConnected ?: false

fun Context.getColorInt(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}

fun Context.getDimenPxFloat(@DimenRes dimenResId: Int): Float {
    return resources.getDimensionPixelSize(dimenResId).toFloat()
}

fun Context.getDimenPxInt(@DimenRes dimenResId: Int): Int {
    return resources.getDimensionPixelSize(dimenResId)
}

fun Context.getDimenDpFloat(@DimenRes dimenResId: Int): Float {
    return resources.getDimension(dimenResId).let(::pxToDp)
}

fun Context.getDimenDpInt(@DimenRes dimenResId: Int): Int {
    return getDimenDpFloat(dimenResId).toInt()
}

fun Context.getInt(@IntegerRes integerResId: Int): Int {
    return resources.getInteger(integerResId)
}

fun Context.pxToDp(pixValue: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pixValue, resources.displayMetrics)
}

fun Context.pxToDp(pixValue: Int): Int {
    return TypedValue
        .applyDimension(TypedValue.COMPLEX_UNIT_PX, pixValue.toFloat(), resources.displayMetrics)
        .toInt()
}

fun Context.getFont(@FontRes fontResId: Int): Typeface? {
    return ResourcesCompat.getFont(this, fontResId)
}
