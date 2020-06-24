package ru.skillbranch.sbdelivery.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.skillbranch.sbdelivery.SBDeliveryApp
import ru.skillbranch.sbdelivery.data.common.ResponseErrorBodyConverter

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