package ru.skillbranch.sbdelivery.dish.view

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel

/**
 * Created by Anna Shabaeva on 12.07.2020
 */

@Parcelize
class DishArgs(val dishModel: DishModel) : Parcelable