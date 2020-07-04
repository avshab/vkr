package ru.skillbranch.sbdelivery.data.common.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.skillbranch.sbdelivery.data.auth.model.UserAuthDbDto
import ru.skillbranch.sbdelivery.data.auth.storage.UserAuthDao

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

@Database(
    version = 1,
    entities = [
        UserAuthDbDto::class
    ]
)
abstract class SbDeliveryRoomDatabase : RoomDatabase() {
    abstract val authDao: UserAuthDao
}