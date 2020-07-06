package ru.skillbranch.sbdelivery.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.SBDeliveryApp
import ru.skillbranch.sbdelivery.common.view.zerodata.DefaultZeroDataFactory
import javax.inject.Provider

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
//    fun provideDefaultZeroDataFactory() = DefaultZeroDataFactory()
}