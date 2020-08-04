package ru.skillbranch.sbdelivery.dish.view.builder

import android.text.Spannable
import android.text.style.ForegroundColorSpan
import android.text.style.StrikethroughSpan
import androidx.core.text.toSpannable
import ru.skillbranch.sbdelivery.R
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.dish.view.cells.DishHeaderCell
import ru.skillbranch.sbdelivery.dish.view.cells.ReviewCell
import ru.skillbranch.sbdelivery.dish.view.cells.ReviewHeaderCell
import ru.skillbranch.sbdelivery.domain.dish.model.DishReviewModel
import ru.skillbranch.sbdelivery.utils.datetime.DateModel
import ru.skillbranch.sbdelivery.utils.datetime.DateTimeFormatter
import ru.skillbranch.sbdelivery.utils.exceptions.RUB_SYMBOL
import ru.skillbranch.sbdelivery.utils.exceptions.WHITESPACE
import ru.skillbranch.sbdelivery.utils.extensions.setSpanExclusive
import ru.skillbranch.sbdelivery.utils.resources.ResourcesManager
import kotlin.math.roundToInt

class DishCellBuilder(
    private val resourcesManager: ResourcesManager
) {

    fun build(
        title: String,
        description: String,
        price: Int,
        oldPrice: Int?,
        url: String,
        summaryRating: Double,
        reviews: List<DishReviewModel>
    ): List<BaseCell> {


        val reviewCells = reviews.map { review ->
            ReviewCell(
                title = review.author + "," + WHITESPACE + DateTimeFormatter()
                    .formatDateStandard(
                        DateModel(review.date)
                    ),
                rating = review.rating,
                text = review.text
            )
        }
        var result: List<BaseCell> = listOf(
            DishHeaderCell(
                title = title,
                description = description,
                price = buildSpannablePrice(price, oldPrice),
                url = url,
                isDiscount = oldPrice != null
            )
        )
        if (reviewCells.isNotEmpty()) {

            val rating = (summaryRating * 100.0).roundToInt() / 100.0
            result = result + listOf(ReviewHeaderCell(rating.toString()))
        }
        return result + reviewCells
    }

    fun buildHeader(
        title: String,
        description: String,
        price: Int,
        oldPrice: Int?,
        url: String
    ): List<BaseCell> {
        return listOf(
            DishHeaderCell(
                title = title,
                description = description,
                price = buildSpannablePrice(price, oldPrice),
                url = url,
                isDiscount = oldPrice != null
            )
        )
    }

    private fun buildSpannablePrice(
        price: Int,
        oldPrice: Int?
    ): Spannable {

        return oldPrice?.let {
            val resultStr = oldPrice.toString() + WHITESPACE + price.toString() + WHITESPACE + RUB_SYMBOL
            return resultStr.setSpanExclusive(
                span = StrikethroughSpan(),
                from = 0,
                to = oldPrice.toString().length
            ).setSpanExclusive(
                span = ForegroundColorSpan(resourcesManager.getColor(R.color.white)),
                from = 0,
                to = oldPrice.toString().length
            )
        } ?: price.toString().toSpannable()
    }
}