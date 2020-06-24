package ru.skillbranch.sbdelivery.common.view.adapter.delegates

import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

abstract class AbsCellDelegate<C : BaseCell, VH : RecyclerView.ViewHolder>(

    @LayoutRes protected val cellLayout: Int

) : AbsListItemAdapterDelegate<C, BaseCell, VH>() {

    override fun isForViewType(
        item: BaseCell,
        items: MutableList<BaseCell>,
        position: Int
    ): Boolean {
        return item.cellLayout == cellLayout
    }

    final override fun onBindViewHolder(cell: C, viewHolder: VH, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            onBindCell(cell, viewHolder)
        } else {
            onUpdateCell(cell, viewHolder, payloads)
        }
    }

    final override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        @Suppress("UNCHECKED_CAST")
        (holder as? VH)?.let(::onViewHolderRecycled)
    }

    abstract fun onBindCell(
        cell: C,
        viewHolder: VH
    )

    open fun onUpdateCell(
        cell: C,
        viewHolder: VH,
        payloads: MutableList<Any>
    ) = Unit

    open fun onViewHolderRecycled(viewHolder: VH) = Unit

}