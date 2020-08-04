package ru.skillbranch.sbdelivery.basket.view.adapter

import ru.skillbranch.sbdelivery.common.view.adapter.BaseCellDelegatcionAdapter
import ru.skillbranch.sbdelivery.common.view.adapter.diff.BaseDiffCallback

/**
 * Created by Anna Shabaeva on 28.07.2020
 */
class BasketAdapter() : BaseCellDelegatcionAdapter(BaseDiffCallback()) {

    init {
        with(delegatesManager) {

        }
    }
}