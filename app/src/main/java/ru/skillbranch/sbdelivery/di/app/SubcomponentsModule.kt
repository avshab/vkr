package ru.skillbranch.sbdelivery.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.skillbranch.sbdelivery.dashboard.di.DashboardModule
import ru.skillbranch.sbdelivery.dashboard.di.DashboardScope
import ru.skillbranch.sbdelivery.dashboard.view.DashboardFragment
import ru.skillbranch.sbdelivery.main.view.MainActivity
import ru.skillbranch.sbdelivery.main.di.MainScope

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

@Module
abstract class SubcomponentsModule {

    @MainScope
    @ContributesAndroidInjector
    abstract fun buildMainActivity(): MainActivity

    @DashboardScope
    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun buildDashboardFragment(): DashboardFragment
}