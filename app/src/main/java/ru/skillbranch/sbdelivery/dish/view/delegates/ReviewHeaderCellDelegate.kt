package ru.skillbranch.sbdelivery.dish.view.delegates

import kotlinx.android.synthetic.main.cell_review_header.view.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dish.view.cells.ReviewHeaderCell
import ru.skillbranch.sbdelivery.utils.extensions.onClick

class ReviewHeaderCellDelegate(private val addReview: () -> Unit) :
    BaseCellDelegate<ReviewHeaderCell>(
        ReviewHeaderCell.VIEW_TYPE
    ) {

    override fun onViewHolderCreated(viewHolder: BaseCellViewHolder) {
        super.onViewHolderCreated(viewHolder)
            viewHolder.itemView.addReview.onClick { addReview() }
    }

    override fun onBindCell(cell: ReviewHeaderCell, viewHolder: BaseCellViewHolder) {
    }
}