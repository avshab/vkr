package ru.skillbranch.sbdelivery.utils.resources

import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.*

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

interface ResourcesManager {

    @ColorInt
    fun getColor(@ColorRes colorResId: Int): Int

    fun getString(@StringRes stringResId: Int): String

    fun getString(@StringRes stringResId: Int, vararg args: Any): String

    fun getDimenDp(@DimenRes dimeRsId: Int): Float

    fun getDimenPx(@DimenRes dimeRsId: Int): Float

    //fun getPlural(@PluralsRes pluralsResId: Int, displayedQuantity: Int, quantity: Int): String

    fun getDrawable(@DrawableRes drawableResId: Int): Drawable

    fun getInteger(@IntegerRes integerResId: Int): Int

    fun getFont(@FontRes fontResId: Int): Typeface?
}