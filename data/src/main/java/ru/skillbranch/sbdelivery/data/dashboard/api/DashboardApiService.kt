package ru.skillbranch.sbdelivery.data.dashboard.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.dashboard.model.IDS

/**
 * Created by Anna Shabaeva on 07.06.2020
 */

interface DashboardApiService {

    @GET("dishes")
    fun getDishes(
        @Query("offset") offset: Long = 0,
        @Query("limit") limit: Long = 10
    ): Single<List<DishModel>?>


    @GET("main/recommend")
    fun getRecommend(): Single<List<IDS>?>
}