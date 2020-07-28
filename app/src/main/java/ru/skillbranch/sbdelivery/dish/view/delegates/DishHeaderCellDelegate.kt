package ru.skillbranch.sbdelivery.dish.view.delegates

import kotlinx.android.synthetic.main.cell_dish_header.view.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dish.view.cells.DishHeaderCell
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone
import com.bumptech.glide.Glide
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


            Glide
                .with(dishImageView.context)
                .load(cell.url)
                .apply(
                    com.bumptech.glide.request.RequestOptions
                        .bitmapTransform(com.bumptech.glide.load.resource.bitmap.CenterCrop())
                        .downsample(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy.AT_LEAST)
                        .error(ru.skillbranch.sbdelivery.R.drawable.ic_error_unspecified)
                        .diskCacheStrategy(com.bumptech.glide.load.engine.DiskCacheStrategy.ALL)
                )
                .into(dishImageView)

            addToBasketButton.onClick { addToBasket(counterView.getCounter()) }

            badgeTextView.makeVisibleOrGone(cell.isDiscount)
        }
    }

}