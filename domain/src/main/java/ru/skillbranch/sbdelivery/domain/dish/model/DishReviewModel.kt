package ru.skillbranch.sbdelivery.domain.dish.model

import java.util.*

/**
 * Created by Anna Shabaeva on 16.07.2020
 */

data class DishReviewModel(
    val dishId: String,
    val author: String,
    val date: Date,
    val rating: Int,
    val text: String,
    val active: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)