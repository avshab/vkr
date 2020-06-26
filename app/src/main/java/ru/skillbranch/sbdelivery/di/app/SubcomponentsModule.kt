package ru.skillbranch.sbdelivery.di.app

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.skillbranch.sbdelivery.auth.login.di.LoginModule
import ru.skillbranch.sbdelivery.auth.login.di.LoginScope
import ru.skillbranch.sbdelivery.auth.login.view.LoginFragment
import ru.skillbranch.sbdelivery.dashboard.di.DashboardModule
import ru.skillbranch.sbdelivery.dashboard.di.DashboardScope
import ru.skillbranch.sbdelivery.dashboard.view.DashboardFragment
import ru.skillbranch.sbdelivery.launch.di.LaunchModule
import ru.skillbranch.sbdelivery.launch.view.LaunchFragment
import ru.skillbranch.sbdelivery.main.view.MainActivity
import ru.skillbranch.sbdelivery.main.di.MainScope
import ru.skillbranch.sbdelivery.menu.di.MenuModule
import ru.skillbranch.sbdelivery.menu.di.MenuScope
import ru.skillbranch.sbdelivery.menu.view.MenuFragment

/**
 * Created by Anna Shabaeva on 06.06.2020
 */

@Module
abstract class SubcomponentsModule {

    @MainScope
    @ContributesAndroidInjector
    abstract fun buildMainActivity(): MainActivity

    @MenuScope
    @ContributesAndroidInjector(modules = [LaunchModule::class])
    abstract fun buildLaunchFragment(): LaunchFragment

    @DashboardScope
    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun buildDashboardFragment(): DashboardFragment

    @MenuScope
    @ContributesAndroidInjector(modules = [MenuModule::class])
    abstract fun buildMenuFragment(): MenuFragment

    @LoginScope
    @ContributesAndroidInjector(modules = [LoginModule::class])
    abstract fun buildLoginFragment(): LoginFragment
}
