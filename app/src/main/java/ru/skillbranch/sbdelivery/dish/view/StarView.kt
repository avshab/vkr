package ru.skillbranch.sbdelivery.dish.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import ru.skillbranch.sbdelivery.R

class StarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayoutCompat(
    context,
    attrs,
    defStyleAttr
) {
    init {
        val view = View.inflate(
            context,
            R.layout.cell_star,
            this
        )

    }
}