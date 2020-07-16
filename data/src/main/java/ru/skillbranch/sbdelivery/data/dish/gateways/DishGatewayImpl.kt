package ru.skillbranch.sbdelivery.data.dish.gateways

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.dish.api.DishApiService
import ru.skillbranch.sbdelivery.data.dish.api.DishReviewRequestBody
import ru.skillbranch.sbdelivery.domain.dish.gateways.DishGateway
import ru.skillbranch.sbdelivery.domain.dish.model.DishReviewModel

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

class DishGatewayImpl(
    private val apiService: DishApiService,
    private val mapper: BaseResponseMapper
) : DishGateway {

    override fun getReviewsForDish(id: String): Single<List<DishReviewModel>> {
        return apiService.getReviewsForDish(id = id).map {
            mapper.map(it as Response<Any?>) as List<DishReviewModel>
        }
    }

    override fun sendReviewForDish(id: String, rating: Int, text: String): Completable {
        return apiService.sendReviewForDish(
            id = id,
            body = DishReviewRequestBody(rating = rating, text = text)
        )
    }
}