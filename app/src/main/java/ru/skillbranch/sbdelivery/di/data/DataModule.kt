package ru.skillbranch.sbdelivery.di.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.data.common.db.SbDeliveryRoomDatabase
import ru.skillbranch.sbdelivery.di.app.AppScope

/**
 * Created by Anna Shabaeva on 28.06.2020
 */

@Module
class DataModule {

    @Provides
    @AppScope
    fun provideSbDeliveryRoomDatabase(
        context: Context
    ) = Room
        .databaseBuilder(context, SbDeliveryRoomDatabase::class.java, "SB_DELIVERY_DB")
        .build()

}