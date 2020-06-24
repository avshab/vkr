package ru.skillbranch.sbdelivery.dashboard.view.delegates

import kotlinx.android.synthetic.main.cell_dish_card.view.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dashboard.view.cells.DishCardCell
import ru.skillbranch.sbdelivery.utils.exceptions.RUB_SYMBOL
import ru.skillbranch.sbdelivery.utils.exceptions.WHITESPACE

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

class DishCardCellDelegate :
    BaseCellDelegate<DishCardCell>(DishCardCell.VIEW_TYPE) {

    override fun onBindCell(cell: DishCardCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder.itemView) {
            nameTextView.text = cell.name
            priceTextView.text = cell.price.toString() + WHITESPACE + RUB_SYMBOL
        }
    }
}