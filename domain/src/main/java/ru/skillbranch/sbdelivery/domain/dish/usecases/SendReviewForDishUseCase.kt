package ru.skillbranch.sbdelivery.domain.dish.usecases

import ru.skillbranch.sbdelivery.domain.dish.gateways.DishGateway

class SendReviewForDishUseCase(private val dishGateway: DishGateway) {

    fun build(id: String, rating: Int, text: String) =
        dishGateway.sendReviewForDish(id = id, rating = rating, text = text)
}