package ru.skillbranch.sbdelivery.common.view.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.view_counter.view.*
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.utils.extensions.onClick

/**
 * Created by Anna Shabaeva on 11.07.2020
 */

class CounterView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var counter = 1

    init {
        LayoutInflater.from(context)
            .inflate(R.layout.view_counter, this, true)
        orientation = HORIZONTAL
    }

//    override fun onViewAdded(child: View?) {
//        super.onViewAdded(child)
//        minusButton.onClick {
//            if (counter > 1) {
//                counter.dec()
//                updateState()
//            }
//        }
//        plusButton.onClick {
//            counter.inc()
//            updateState()
//        }
//    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        minusButton.onClick {
            if (counter > 1) {
                counter = counter.dec()
                updateState()
            }
        }
        plusButton.onClick {
            counter = counter.inc()
            updateState()
        }
    }

    private fun updateState() {
        countTextView.text = counter.toString()
        minusButton.isEnabled = counter != 1

    }

    fun getCounter() = counter
}