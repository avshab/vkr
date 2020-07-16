package ru.skillbranch.sbdelivery.domain.dish.gateways

import io.reactivex.Completable
import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.dish.model.DishReviewModel

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

interface DishGateway {

    fun getReviewsForDish(id: String) : Single<List<DishReviewModel>>

    fun sendReviewForDish(id: String, rating: Int, text: String) : Completable
}