package ru.skillbranch.sbdelivery.utils.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Created by Anna Shabaeva on 19.06.2020
 */


fun ViewGroup.inflate(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)
