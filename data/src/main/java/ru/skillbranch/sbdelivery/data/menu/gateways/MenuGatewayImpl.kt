package ru.skillbranch.sbdelivery.data.menu.gateways

import io.reactivex.Single
import retrofit2.Response
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.menu.api.CategoriesApiService
import ru.skillbranch.sbdelivery.domain.menu.gateways.MenuGateway
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 10.07.2020
 */

class MenuGatewayImpl (
    private val apiService: CategoriesApiService,
    private val mapper: BaseResponseMapper
): MenuGateway {
    override fun getCategorise(): Single<List<CategoryModel>> {
        return apiService.getCategories().map {
            mapper.map(it as Response<Any?>) as? List<CategoryModel>
        }
    }
}