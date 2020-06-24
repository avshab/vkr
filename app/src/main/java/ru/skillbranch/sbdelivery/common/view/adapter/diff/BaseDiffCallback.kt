package ru.skillbranch.sbdelivery.common.view.adapter.diff

import androidx.recyclerview.widget.DiffUtil
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.common.view.cells.base.IdentifiableCell

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

open class BaseDiffCallback : DiffUtil.ItemCallback<BaseCell>() {

    override fun areItemsTheSame(oldItem: BaseCell, newItem: BaseCell): Boolean {
        return when {
            oldItem.javaClass != newItem.javaClass -> false
            oldItem is IdentifiableCell<*> && newItem is IdentifiableCell<*> -> {
                oldItem.cellId == newItem.cellId
            }
            else -> oldItem.hashCode() == newItem.hashCode()
        }
    }

    override fun areContentsTheSame(oldItem: BaseCell, newItem: BaseCell): Boolean {
        return oldItem == newItem
    }

}