package ru.skillbranch.sbdelivery.di.data

import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.auth.storage.UserAuthStorage
import ru.skillbranch.sbdelivery.data.common.db.SbDeliveryRoomDatabase
import ru.skillbranch.sbdelivery.data.common.userData.UserDataStorage
import ru.skillbranch.sbdelivery.data.common.userData.UserDataStorageImpl
import ru.skillbranch.sbdelivery.di.app.AppScope

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

    @Provides
    @AppScope
    fun provideUserDataStorage(): UserDataStorage {
        return UserDataStorageImpl()
    }
}