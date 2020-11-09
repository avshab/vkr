package ru.skillbranch.sbdelivery.menu.view

import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import kotlinx.android.synthetic.main.cell_menu.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.utils.extensions.onClick

/**
 * Created by Anna Shabaeva on 24.06.2020
 */
class MenuCellDelegate(private val categoryClick: (id: String) -> Unit) :
    BaseCellDelegate<MenuCell>(MenuCell.VIEW_TYPE) {

    override fun onBindCell(cell: MenuCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder) {
            titleTextView.text = cell.title

            val imageLoader = ImageLoader.Builder(menuItemImageView.context)
                .componentRegistry {
                    add(SvgDecoder(menuItemImageView.context))
                }
                .build()

            val request = ImageRequest.Builder(menuItemImageView.context)
                .data(cell.iconUrl)
                .target(menuItemImageView)
                .build()
            imageLoader.enqueue(request)

            itemView.onClick {
                categoryClick(cell.cellId)
            }
        }
    }
}