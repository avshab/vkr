package ru.skillbranch.sbdelivery.domain.menu.model

/**
 * Created by Anna Shabaeva on 10.07.2020
 */

data class CategoryModel(
    val categoryId: String,
    val name: String,
    val order: Int,
    val icon: String?,
    val parent: String?,
    val active: Boolean,
    val createdAt: Long,
    val updatedAt: Long
)