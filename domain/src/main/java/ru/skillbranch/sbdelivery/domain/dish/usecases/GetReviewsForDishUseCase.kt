package ru.skillbranch.sbdelivery.domain.dish.usecases

import ru.skillbranch.sbdelivery.domain.dish.gateways.DishGateway

/**
 * Created by Anna Shabaeva on 16.07.2020
 */
class GetReviewsForDishUseCase(private val dishGateway: DishGateway) {

    fun buildSingle(id: String) = dishGateway.getReviewsForDish(id)
}

