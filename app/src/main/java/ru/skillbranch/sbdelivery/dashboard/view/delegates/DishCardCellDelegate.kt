package ru.skillbranch.sbdelivery.dashboard.view.delegates

import coil.load
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dashboard.view.cells.DishCardCell
import ru.skillbranch.sbdelivery.utils.exceptions.RUB_SYMBOL
import ru.skillbranch.sbdelivery.utils.exceptions.WHITESPACE
import kotlinx.android.synthetic.main.cell_dish_card.view.badgeTextView
import kotlinx.android.synthetic.main.cell_dish_card.view.dishImageView
import kotlinx.android.synthetic.main.cell_dish_card.view.likeButton
import kotlinx.android.synthetic.main.cell_dish_card.view.nameTextView
import kotlinx.android.synthetic.main.cell_dish_card.view.priceTextView
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.utils.extensions.getColorInt
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone
import ru.skillbranch.sbdelivery.utils.extensions.onClick

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

class DishCardCellDelegate(
    private val onDishClicked: (data: DishModel) -> Unit,
    private val addToBasket: () -> Unit,
    private val likeItem: () -> Unit
) :
    BaseCellDelegate<DishCardCell>(DishCardCell.VIEW_TYPE) {

    override fun onViewHolderCreated(viewHolder: BaseCellViewHolder) {
    }

    override fun onBindCell(cell: DishCardCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder.itemView) {

            onClick {
                onDishClicked(cell.data)
            }

            nameTextView.text = cell.data.name
            priceTextView.text = cell.data.price.toString() + WHITESPACE + RUB_SYMBOL


            dishImageView.load(cell.data.image) {
                crossfade(true)
                placeholder(R.drawable.ic_error_unspecified)
            }

            if(cell.like) {
                likeButton.setColorFilter(likeButton.getColorInt(R.color.color_second_accent))
            }

            badgeTextView.makeVisibleOrGone(cell.isDiscount)
        }
    }
}