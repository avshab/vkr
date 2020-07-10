package ru.skillbranch.sbdelivery.domain.menu.gateways

import io.reactivex.Single
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 10.07.2020
 */
interface MenuGateway {

    fun getCategorise(): Single<List<CategoryModel>>
}
