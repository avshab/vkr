package ru.skillbranch.sbdelivery.common.view.adapter.delegates

import android.view.ViewGroup
import ru.skillbranch.sbdelivery.common.view.adapter.viewholders.BaseCellViewHolder
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell
import ru.skillbranch.sbdelivery.utils.extensions.inflate

/**
 * Created by Anna Shabaeva on 19.06.2020
 */
abstract class BaseCellDelegate<C : BaseCell>(

    cellLayout: Int

) : AbsCellDelegate<C, BaseCellViewHolder>(cellLayout) {

    override fun onCreateViewHolder(parent: ViewGroup): BaseCellViewHolder {
        return BaseCellViewHolder(parent.inflate(cellLayout)).also(::onViewHolderCreated)
    }

    open fun onViewHolderCreated(viewHolder: BaseCellViewHolder) = Unit

}