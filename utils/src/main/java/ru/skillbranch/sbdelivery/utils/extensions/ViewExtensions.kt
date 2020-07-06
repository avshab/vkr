package ru.skillbranch.sbdelivery.utils.extensions

import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat

/**
 * Created by Anna Shabaeva on 19.06.2020
 */


fun ViewGroup.inflate(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)

fun View.getColorInt(@ColorRes colorRes: Int): Int = ContextCompat.getColor(context, colorRes)

fun View.getString(@StringRes stringResId: Int): String? {
    return context?.getString(stringResId)
}

fun View.getDrawable(@DrawableRes drawableResId: Int): Drawable? {
    return context?.getDrawable(drawableResId)
}

fun View.isVisible(): Boolean = visibility == View.VISIBLE

fun View.makeGone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.makeVisible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.makeInvisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}


fun View.makeEnable() {
    if (!isEnabled) {
        isEnabled = true
    }
}


fun View.makeDisable() {
    if (isEnabled) {
        isEnabled = false
    }
}

fun View.makeVisibleOrGone(visible: Boolean) {
    if (visible) {
        makeVisible()
    } else {
        makeGone()
    }
}

fun View.makeEnableOrDisable(enable: Boolean) {
    if (enable) {
        makeEnable()
    } else {
        makeDisable()
    }
}

fun View.makeVisibleOrInvisible(visible: Boolean) {
    if (visible) {
        makeVisible()
    } else {
        makeInvisible()
    }
}

fun View.onClick(action: () -> Unit) = setOnClickListener { action.invoke() }

fun View.adjustHeightToFillParent() {
    val parentViewGroup = parent as? ViewGroup ?: return

    val parentPadding = parentViewGroup.paddingTop + parentViewGroup.paddingBottom
    val height = parentViewGroup.height - top - parentPadding
    val adjustedHeight = Math.max(minimumHeight, height)

    layoutParams.height = adjustedHeight

    requestLayout()
}

fun View.dpToPx(dpValue: Float): Float =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, resources.displayMetrics)

fun View.dpToPx(dpValue: Int): Int = (dpValue * resources.displayMetrics.density).toInt()