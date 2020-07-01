package ru.skillbranch.sbdelivery.data.dashboard.api

import com.google.gson.annotations.SerializedName
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseBody
import ru.skillbranch.sbdelivery.domain.dashboard.model.IDS

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class DishesListResponseBody(

    @SerializedName("data")
    val data: List<Any>? = null

) : BaseResponseBody()

class RecommendedDishesResponseBody(

    @SerializedName("data")
    val data: List<IDS>? = null

) : BaseResponseBody()