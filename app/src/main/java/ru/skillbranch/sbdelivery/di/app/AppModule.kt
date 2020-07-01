package ru.skillbranch.sbdelivery.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.SBDeliveryApp

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideAppContext(app: SBDeliveryApp): Context = app.applicationContext
//
//    @Provides
//    @AppScope
//    fun provideResponseErrorBodyConverter(): ResponseErrorBodyConverter {
//        return ResponseErrorBodyConverter()
//    }
}