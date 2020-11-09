package ru.skillbranch.sbdelivery.data.dish.api

import com.google.gson.annotations.SerializedName
import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.*
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.dish.model.DishReviewModel

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

interface DishApiService {

    @GET("reviews/{id}")
    fun getReviewsForDish(
        @Path("id") id: String,
        @Query("offset") offset: Long = 0,
    @Query("limit") limit: Long = 100
    ): Single<Response<List<DishReviewModel>>>

    @POST("reviews/{id}")
    fun sendReviewForDish(
        @Path("id") id: String,
        @Body body: DishReviewRequestBody
    ): Completable

    @GET("dishes")
    fun getDishes(
        @Query("offset") offset: Long = 0,
        @Query("limit") limit: Long = 10
    ): Single<Response<List<DishModel>?>>
}

class DishReviewRequestBody(

    @SerializedName("rating")
    val rating: Int,

    @SerializedName("text")
    val text: String
)