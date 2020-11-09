package ru.skillbranch.sbdelivery.domain.launch.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

interface LaunchGateway {

    fun loadMenuCategories(): Single<List<CategoryModel>>

    fun loadDishes(): Single<List<DishModel>>
}