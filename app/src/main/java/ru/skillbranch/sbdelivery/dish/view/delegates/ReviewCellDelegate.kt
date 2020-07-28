package ru.skillbranch.sbdelivery.dish.view.delegates

import kotlinx.android.synthetic.main.cell_review_item.view.*
import kotlinx.android.synthetic.main.cell_review_item.view.reviewTextView
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dish.view.StarView
import ru.skillbranch.sbdelivery.dish.view.cells.ReviewCell
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

class ReviewCellDelegate : BaseCellDelegate<ReviewCell>(ReviewCell.VIEW_TYPE) {

    override fun onBindCell(cell: ReviewCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder.itemView) {
            authorTextView.text = cell.title
            reviewTextView.text = cell.text
            reviewTextView.makeVisibleOrGone(!cell.text.isNullOrBlank())
            starsLayout.removeAllViews()
            for (i in 1..cell.rating) {
                val view = StarView(context)
                starsLayout.addView(
                    view
                )
            }
        }
    }
}
