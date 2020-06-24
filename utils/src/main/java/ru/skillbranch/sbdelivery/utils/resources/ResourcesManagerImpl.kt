package ru.skillbranch.sbdelivery.utils.resources

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import ru.skillbranch.sbdelivery.utils.exceptions.*

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

class ResourcesManagerImpl(private val context: Context) : ResourcesManager {

    @ColorInt
    override fun getColor(colorResId: Int): Int {
        return context.getColorInt(colorResId)
    }

    override fun getString(stringResId: Int): String {
        return context.getString(stringResId)
    }

    override fun getString(stringResId: Int, vararg args: Any): String {
        return context.getString(stringResId, *args)
    }

    override fun getDimenDp(dimeRsId: Int): Float {
        return context.getDimenDpFloat(dimeRsId)
    }

    override fun getDimenPx(dimeRsId: Int): Float {
        return context.getDimenPxFloat(dimeRsId)
    }

//    override fun getPlural(pluralsResId: Int, displayedQuantity: Int, quantity: Int): String {
//        return context.getPlural(pluralsResId, displayedQuantity, quantity)!!
//    }

    override fun getDrawable(drawableResId: Int): Drawable {
        return context.getDrawable(drawableResId) as Drawable
    }

    override fun getInteger(integerResId: Int): Int {
        return context.getInt(integerResId)
    }

    override fun getFont(fontResId: Int): Typeface? {
        return context.getFont(fontResId)
    }

}