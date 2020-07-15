package ru.skillbranch.sbdelivery.domain.dashboard.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Anna Shabaeva on 07.06.2020
 */
@Parcelize
data class DishModel(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val oldPrice: String?,
    val price: Int,
    val rating: Int,
    val likes: Int,
    val category: String,
    val commentsCount: Int,
    val active: Boolean,
    val createdAt: Long,
    val updatedAt: Long
) : Parcelable