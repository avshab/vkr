package ru.skillbranch.sbdelivery.dish.view.delegates

import coil.load
import kotlinx.android.synthetic.main.cell_dish_header.view.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dish.view.cells.DishHeaderCell
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.utils.extensions.onClick

class DishHeaderCellDelegate(private val addToBasket: (count: Int) -> Unit) :
    BaseCellDelegate<DishHeaderCell>(
        DishHeaderCell.VIEW_TYPE
    ) {
    override fun onBindCell(cell: DishHeaderCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder.itemView) {
            nameTextView.text = cell.title
            descriptionTextView.text = cell.description
            priceTextView.text = cell.price

            dishImageView.load(cell.url) {
                crossfade(true)
                placeholder(R.drawable.ic_error_unspecified)
            }

            addToBasketButton.onClick { addToBasket(counterView.getCounter()) }

            badgeTextView.makeVisibleOrGone(cell.isDiscount)
        }
    }

}