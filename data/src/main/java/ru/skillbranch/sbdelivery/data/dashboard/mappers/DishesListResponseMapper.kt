package ru.skillbranch.sbdelivery.data.dashboard.mappers

import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.common.api.ResponseErrorBodyConverter
import ru.skillbranch.sbdelivery.data.dashboard.api.DishesListResponseBody
import ru.skillbranch.sbdelivery.data.dashboard.api.RecommendedDishesResponseBody
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.dashboard.model.IDS
import ru.skillbranch.sbdelivery.utils.exceptions.defaultIfNull

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

class DishesListResponseMapper(
    errorBodyConverter: ResponseErrorBodyConverter
) : BaseResponseMapper<DishesListResponseBody, List<DishModel>>(errorBodyConverter) {

    override fun mapResult(responseBody: DishesListResponseBody): List<DishModel> {
        return emptyList()
    }

}

class IdsResponseMapper(
    errorBodyConverter: ResponseErrorBodyConverter
) : BaseResponseMapper<RecommendedDishesResponseBody, List<IDS>>(errorBodyConverter) {
    override fun mapResult(responseBody: RecommendedDishesResponseBody): List<IDS> {
        return responseBody.data?.map { it.defaultIfNull }.defaultIfNull
    }
}