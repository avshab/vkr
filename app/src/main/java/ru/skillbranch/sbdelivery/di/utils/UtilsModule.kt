package ru.skillbranch.sbdelivery.di.utils

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.skillbranch.sbdelivery.di.app.AppScope
import ru.skillbranch.sbdelivery.utils.interceptor.ConnectionChecker
import ru.skillbranch.sbdelivery.utils.interceptor.ConnectionCheckerImpl
import ru.skillbranch.sbdelivery.utils.resources.ResourcesManager
import ru.skillbranch.sbdelivery.utils.resources.ResourcesManagerImpl
import ru.skillbranch.sbdelivery.utils.rx.Schedulers
import ru.skillbranch.sbdelivery.utils.rx.SchedulersImpl

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

@Module
class UtilsModule {

    @Provides
    @AppScope
    fun provideResourcesManager(context: Context): ResourcesManager {
        return ResourcesManagerImpl(context)
    }

    @Provides
    @AppScope
    fun provideConnectionChecker(context: Context): ConnectionChecker {
        return ConnectionCheckerImpl(context)
    }

    @Provides
    @AppScope
    fun provideSchedulersFacade(): Schedulers = SchedulersImpl()

}