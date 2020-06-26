package ru.skillbranch.sbdelivery.menu.view

import kotlinx.android.synthetic.main.cell_menu.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder

/**
 * Created by Anna Shabaeva on 24.06.2020
 */
class MenuCellDelegate : BaseCellDelegate<MenuCell>( MenuCell.VIEW_TYPE ) {

    override fun onBindCell(cell: MenuCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder) {
            titleTextView.text = cell.title
        }
    }
}