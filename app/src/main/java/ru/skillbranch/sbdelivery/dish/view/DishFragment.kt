package ru.skillbranch.sbdelivery.dish.view

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.fragment_dish.*
import ru.skillbranch.sbdelivery.common.view.BaseFragment
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.dish.model.DishViewModel
import ru.skillbranch.sbdelivery.utils.exceptions.RUB_SYMBOL
import ru.skillbranch.sbdelivery.utils.exceptions.WHITESPACE
import ru.skillbranch.sbdelivery.utils.extensions.arguments
import ru.skillbranch.sbdelivery.utils.extensions.makeVisibleOrGone
import ru.skillbranch.sbdelivery.utils.extensions.onClick
import javax.inject.Inject

/**
 * Created by Anna Shabaeva on 11.07.2020
 */

class DishFragment : BaseFragment() {

    override val layoutResId: Int = R.layout.fragment_dish

    override val toolbarVisibility: Boolean = false

    @Inject lateinit var viewModel: DishViewModel

    private val fragmentArgs by arguments<DishArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(fragmentArgs.dishModel) {
            setupSecondToolBar(name)

            Glide
                .with(dishImageView.context)
                .load(image)
                .apply(
                    RequestOptions
                        .bitmapTransform(CenterCrop())
                        .downsample(DownsampleStrategy.FIT_CENTER)
                        .error(R.drawable.ic_error_unspecified)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                )
                .into(dishImageView)

            badgeTextView.makeVisibleOrGone(!oldPrice.isNullOrBlank())

            nameTextView.text = name
            descriptionTextView.text = description
            descriptionTextView.makeVisibleOrGone(!description.isNullOrBlank())

            priceTextView.text = price.toString() + WHITESPACE + RUB_SYMBOL
        }


        addTpBasketButton.onClick(viewModel::addToBasket)

    }
}