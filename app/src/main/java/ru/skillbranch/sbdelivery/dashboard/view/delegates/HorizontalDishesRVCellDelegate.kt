package ru.skillbranch.sbdelivery.dashboard.view.delegates

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.cell_horizontal_rv.view.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.dashboard.view.adapter.DishCardAdapter
import ru.skillbranch.sbdelivery.dashboard.view.cells.DishCardCell
import ru.skillbranch.sbdelivery.dashboard.view.cells.HorizontalDishesRVCell
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel

/**
 * Created by Anna Shabaeva on 19.06.2020
 */
class HorizontalDishesRVCellDelegate(
    private val onDishClicked: (data: DishModel) -> Unit,
    private val addToBasket: () -> Unit,
    private val likeItem: () -> Unit
) :
    BaseCellDelegate<HorizontalDishesRVCell>(HorizontalDishesRVCell.VIEW_TYPE) {

    override fun onBindCell(cell: HorizontalDishesRVCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder.itemView) {
            val cardAdapter = DishCardAdapter(
                onDishClicked = onDishClicked,
                addToBasket = addToBasket,
                likeItem = likeItem
            )
            horizontalRV.apply {
                adapter = cardAdapter
                layoutManager =
                    LinearLayoutManager(horizontalRV.context, LinearLayoutManager.HORIZONTAL, false)
            }
            cardAdapter.items = bindCells(cell.data)
        }
    }

    private fun bindCells(list: List<DishModel>): List<BaseCell> {
        return list.map {
            //TODO like from storage
            DishCardCell(data = it, like = it.likes > 0, isDiscount = it.oldPrice != null)
        }
    }
}