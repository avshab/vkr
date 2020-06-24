package ru.skillbranch.sbdelivery.common.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import ru.skillbranch.sbdelivery.common.view.cells.BaseCell

/**
 * Created by Anna Shabaeva on 19.06.2020
 */
open class BaseCellDelegatcionAdapter(
    diffCallback: DiffUtil.ItemCallback<BaseCell>
) : AsyncListDifferDelegationAdapter<BaseCell>(diffCallback) {

    fun getItem(position: Int): BaseCell? = items.getOrNull(position)

}

