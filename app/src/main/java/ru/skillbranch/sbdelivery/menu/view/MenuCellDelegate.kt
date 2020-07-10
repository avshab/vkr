package ru.skillbranch.sbdelivery.menu.view

import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.cell_menu.*
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.adapter.delegates.BaseCellDelegate
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder

/**
 * Created by Anna Shabaeva on 24.06.2020
 */
class MenuCellDelegate : BaseCellDelegate<MenuCell>( MenuCell.VIEW_TYPE ) {

    override fun onBindCell(cell: MenuCell, viewHolder: BaseCellViewHolder) {
        with(viewHolder) {
            titleTextView.text = cell.title

            Glide
                .with(menuItemImageView.context)
                .load(cell.iconUrl)
                .apply(
                    RequestOptions
                        .bitmapTransform(CenterCrop())
                        .downsample(DownsampleStrategy.AT_LEAST)
                        .error(R.drawable.ic_error_unspecified)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(menuItemImageView)
        }
    }
}