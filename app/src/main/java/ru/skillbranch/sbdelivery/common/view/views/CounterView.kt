package ru.skillbranch.sbdelivery.common.view.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import ru.skillbranch.sbdelivery.R

/**
 * Created by Anna Shabaeva on 11.07.2020
 */

class CounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_counter, this, true)
        orientation = HORIZONTAL
    }
}