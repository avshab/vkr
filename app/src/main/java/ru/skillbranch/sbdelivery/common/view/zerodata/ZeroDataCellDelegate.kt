package ru.skillbranch.sbdelivery.common.view.zerodata

import androidx.core.view.doOnPreDraw
import kotlinx.android.synthetic.main.cell_zero_data.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.utils.extensions.adjustHeightToFillParent
import ru.skillbranch.sbdelivery.utils.extensions.dpToPx
import ru.skillbranch.sbdelivery.utils.extensions.onClick

class ZeroDataCellDelegate(
    private val fillParent: Boolean = true,
    private val minHeightDp: Int = ZeroDataCell.DEFAULT_MIN_HEIGHT_PD,
    private val onButtonClickListener: (() -> Unit)? = null

) : BaseCellDelegate<ZeroDataCell>(
    ZeroDataCell.VIEW_TYPE

) {

    override fun onViewHolderCreated(viewHolder: BaseCellViewHolder) {
        onButtonClickListener?.let { onButtonClickListener ->
            viewHolder.zeroDataView.button.onClick(onButtonClickListener)
        }
    }

    override fun onBindCell(cell: ZeroDataCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder) {
            itemView.minimumHeight = itemView.dpToPx(minHeightDp)

            zeroDataView.setup(
                cell.iconRes,
                cell.titleRes,
                cell.contentMessageRes,
                cell.buttonTextRes
            )

            if (fillParent) {
                itemView.doOnPreDraw { view ->
                    view.adjustHeightToFillParent()
                }
            }
        }
    }
}