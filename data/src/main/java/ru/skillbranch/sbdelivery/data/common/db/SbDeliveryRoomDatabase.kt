package ru.skillbranch.sbdelivery.data.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.skillbranch.sbdelivery.data.auth.model.UserAuthDbDto
import ru.skillbranch.sbdelivery.data.auth.storage.UserAuthDao
import ru.skillbranch.sbdelivery.data.common.model.DishesDbDto
import ru.skillbranch.sbdelivery.data.common.model.MenuCategoriesDbDto
import ru.skillbranch.sbdelivery.data.common.storage.DishesDao
import ru.skillbranch.sbdelivery.data.common.storage.MenuCategoriesDao

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

@Database(
    version = 1,
    entities = [
        UserAuthDbDto::class,
        MenuCategoriesDbDto::class,
        DishesDbDto::class
    ]
)
abstract class SbDeliveryRoomDatabase : RoomDatabase() {
    abstract val authDao: UserAuthDao
    abstract val menuCategoriesDao: MenuCategoriesDao
    abstract val dishDao: DishesDao
}