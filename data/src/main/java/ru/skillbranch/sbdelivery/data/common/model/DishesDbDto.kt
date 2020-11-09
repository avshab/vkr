package ru.skillbranch.sbdelivery.data.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.skillbranch.sbdelivery.domain.dashboard.model.DishModel

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

@Entity(tableName = "dishList")
class DishesDbDto(
    val id: String,
    val name: String,
    val description: String,
    val image: String,
    val oldPrice: Int?,
    val price: Int,
    val rating: Double,
    val likes: Int,
    val category: String,
    val commentsCount: Int,
    val active: Boolean,
    val createdAt: Long,
    val updatedAt: Long
) {

    /**
     * Pre-define constant primary key to force single record in table.
     */
    @PrimaryKey
    var primaryKey: Int = 1

    companion object {
        fun setup(model: DishModel): DishesDbDto {
            return DishesDbDto(
                id = model.id,
                name = model.name,
                description = model.description,
                image = model.image,
                oldPrice = model.oldPrice,
                price = model.price,
                rating = model.rating,
                likes = model.likes,
                category = model.category,
                commentsCount = model.commentsCount,
                active = model.active,
                createdAt = model.createdAt,
                updatedAt = model.updatedAt
            )
        }
    }

}
