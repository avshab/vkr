package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.auth.api.model.UserAuthStorage
import ru.skillbranch.sbdelivery.data.common.db.SbDeliveryRoomDatabase

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

@Module
class StorageModule {

    @Provides
    fun provideUserAuthStorage(
        room: SbDeliveryRoomDatabase
    ): UserAuthStorage {
        return room.authDao
    }
}