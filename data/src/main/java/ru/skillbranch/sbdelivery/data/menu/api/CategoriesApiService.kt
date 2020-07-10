package ru.skillbranch.sbdelivery.data.menu.api

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 10.07.2020
 */

interface CategoriesApiService {
    @GET("categories")
    fun getCategories(
        @Query("offset") offset: Long = 0,
        @Query("limit") limit: Long = 100
    ): Single<Response<List<CategoryModel>>>

}