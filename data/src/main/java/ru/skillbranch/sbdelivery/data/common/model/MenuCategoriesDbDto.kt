package ru.skillbranch.sbdelivery.data.common.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.skillbranch.sbdelivery.domain.menu.model.CategoryModel

/**
 * Created by Anna Shabaeva on 09.11.2020
 */

@Entity(tableName = "menuCategories")
class MenuCategoriesDbDto(
    val categoryId: String,
    val name: String,
    val order: Int,
    val icon: String?,
    val parent: String?,
    val active: Boolean,
    val createdAt: Long,
    val updatedAt: Long
) {

    /**
     * Pre-define constant primary key to force single record in table.
     */
    @PrimaryKey
    var primaryKey: Int = 2

    companion object {
        fun setup(data: CategoryModel): MenuCategoriesDbDto {
            return MenuCategoriesDbDto(
                categoryId = data.categoryId,
                name = data.name,
                order = data.order,
                icon = data.icon,
                parent = data.parent,
                active = data.active,
                createdAt = data.createdAt,
                updatedAt = data.updatedAt
            )
        }
    }

}
//
//class HobbiesConverter {
//    @TypeConverter
//    fun fromHobbies(hobbies: List<CategoryModel?>): CategoryModel {
//        return hobbies.joinToString(",")
//    }
//
//    @TypeConverter
//    fun toHobbies(data: String): List<CategoryModel> {
//        return Arrays.asList(data.split(",".toRegex()).toTypedArray())
//    }
//}