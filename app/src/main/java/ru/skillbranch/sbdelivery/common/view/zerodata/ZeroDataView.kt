package ru.skillbranch.sbdelivery.common.view.zerodata

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.widget.LinearLayoutCompat
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone

/**
 * Created by Anna Shabaeva on 05.07.2020
 */

class ZeroDataView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(
    context,
    attrs,
    defStyleAttr
) {

    val button: Button
    val imageView: ImageView
    val titleTextView: TextView
    val contentTextView: TextView

    init {
        val view = View.inflate(context, R.layout.view_zero_data, this)

        button = view.findViewById(R.id.button)
        imageView = view.findViewById(R.id.iconImageView)
        titleTextView = view.findViewById(R.id.titleTextView)
        contentTextView = view.findViewById(R.id.contentTextView)
    }

    fun setup(
        @DrawableRes iconRes: Int,
        @StringRes titleRes: Int,
        @StringRes contentMessageRes: Int? = null,
        // Pass null if you don't want to show button.
        @StringRes buttonTextRes: Int? = null
    ) {
        imageView.setImageResource(iconRes)
        titleTextView.setText(titleRes)
        contentTextView.makeVisibleOrGone(contentMessageRes != null)
        contentMessageRes?.let(contentTextView::setText)
        button.makeVisibleOrGone(buttonTextRes != null)
        buttonTextRes?.let(button::setText)
    }
}