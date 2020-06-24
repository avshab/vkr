package ru.skillbranch.sbdelivery.common.view.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

open class BaseCellViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer
