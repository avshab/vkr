package ru.skillbranch.sbdelivery.dashboard.view.delegates

import kotlinx.android.synthetic.main.cell_dish_card.view.*
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.dashboard.view.cells.DishCardCell
import ru.skillbranch.sbdelivery.utils.exceptions.RUB_SYMBOL
import ru.skillbranch.sbdelivery.utils.exceptions.WHITESPACE
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestOptions
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.utils.extensions.getColorInt
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

class DishCardCellDelegate :
    BaseCellDelegate<DishCardCell>(DishCardCell.VIEW_TYPE) {

    override fun onBindCell(cell: DishCardCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder.itemView) {

            nameTextView.text = cell.name
            priceTextView.text = cell.price.toString() + WHITESPACE + RUB_SYMBOL


            Glide
                .with(dishImageView.context)
                .load(cell.imgUrl)
                .apply(
                    RequestOptions
                        .bitmapTransform(CenterCrop())
                        .downsample(DownsampleStrategy.AT_LEAST)
                        .error(R.drawable.ic_error_unspecified)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(dishImageView)

            if(cell.like) {
                likeButton.setColorFilter(likeButton.getColorInt(R.color.color_second_accent))
            }

            badgeTextView.makeVisibleOrGone(cell.isDiscount)
        }
    }
}