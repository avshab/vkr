package ru.skillbranch.sbdelivery.data.launch.gateways

import io.reactivex.Single
import retrofit2.Response
import ru.skillbranch.sbdelivery.data.common.api.BaseResponseMapper
import ru.skillbranch.sbdelivery.data.common.model.DishesDbDto
import ru.skillbranch.sbdelivery.data.common.model.MenuCategoriesDbDto
import ru.skillbranch.sbdelivery.data.common.storage.DishesStorage
import ru.skillbranch.sbdelivery.data.common.storage.MenuCategoriesStorage
import ru.skillbranch.sbdelivery.data.dish.api.DishApiService
import ru.skillbranch.sbdelivery.data.menu.api.CategoriesApiService
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.launch.gateways.LaunchGateway
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

class LaunchGatewayImpl(
    private val dishApiService: DishApiService,
    private val categoriesApiService: CategoriesApiService,
    private val dishesStorage: DishesStorage,
    private val menuCategoriesStorage: MenuCategoriesStorage,
    private val mapper: BaseResponseMapper
) : LaunchGateway {


    override fun loadDishes(): Single<List<DishModel>> {
        return dishApiService.getDishes().map {
            val data = mapper.map(it as Response<Any?>) as? List<DishModel>
            data?.let {
                dishesStorage.put(data.map { DishesDbDto.setup(it) })
            }
            data
        }
    }

    override fun loadMenuCategories(): Single<List<CategoryModel>> {
        return categoriesApiService.getCategories().map {
            val data = mapper.map(it as Response<Any?>) as? List<CategoryModel>
            data?.let {
                menuCategoriesStorage.put(data.map { MenuCategoriesDbDto.setup(it) })
            }
            data
        }
    }
}